package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.*;
import hu.elte.alkfejl.DormRooms.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserModeService {
    private static UserModeService instance;

    protected final PersonRepo personRepo;
    protected final RoomRepo roomRepo;
    protected final LayoutRepo layoutRepo;
    protected final BCryptPasswordEncoder passwordEncoder;
    protected final AuthenticatedUser user;

    @Autowired
    protected UserModeService(PersonRepo personRepo, RoomRepo roomRepo, LayoutRepo layoutRepo, BCryptPasswordEncoder passwordEncoder, AuthenticatedUser user) {
        this.personRepo = personRepo;
        this.roomRepo = roomRepo;
        this.layoutRepo = layoutRepo;
        this.passwordEncoder = passwordEncoder;
        this.user = user;
        UserModeService.instance = this;
    }

    public static UserModeService getInstance() {
        assert instance != null;
        return instance;
    }

    public boolean setPassword(String inviteToken, String password) {
        Optional<Person> oPerson = personRepo.findByInviteToken(inviteToken);
        if (oPerson.isEmpty() || password == null || password.isBlank()) return false;

        Person person = oPerson.get();
        person.setPassword(passwordEncoder.encode(password));
        personRepo.save(person);
        return true;
    }

    public Room[] getRooms() {
        return StreamSupport.stream(roomRepo.findAll().spliterator(), false).toArray(Room[]::new);
    }

    public boolean reserveRoom(Room room) {
        return reserveRoom(user.getUser(), room);
    }

    public boolean reserveRoom(Person person, Room room) {
        if (person == null || room == null) return false;

        Layout layout = person.getLayout();
        if (layout != null && room.equals(layout.getRoom())) return true;

        synchronized (LayoutRepo.synchronizationObject) {
            if (room.getLayouts().size() == room.getCapacity()) return false;
            if (!room.getType().isGenderAllowed(person.getGender())) return false;

            if (layout != null) cancelReservation(person);
            layout = new Layout(person, room);
            layoutRepo.save(layout);
        }
        return true;
    }

    public boolean cancelReservation() {
        return cancelReservation(user.getUser());
    }

    public boolean cancelReservation(Person person) {
        if (person == null) return false;

        Layout reservation = person.getLayout();
        if (reservation.getRoom().getLayouts().size() == 1) {
            reservation.getRoom().setType(RoomType.MIXED);
            roomRepo.save(reservation.getRoom());
        }

        layoutRepo.delete(reservation);
        return true;
    }

    public boolean setRoomType(RoomType type) {
        return setRoomType(user.getUser().getLayout().getRoom(), type);
    }

    public boolean setRoomType(Room room, RoomType type) {
        if (room == null || type == null) return false;

        for (Layout l : room.getLayouts()) {
            if (!type.isGenderAllowed(l.getPerson().getGender())) return false;
        }

        room.setType(type);
        roomRepo.save(room);
        return true;
    }
}
