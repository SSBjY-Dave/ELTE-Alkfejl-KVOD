package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserModeService {
    private static UserModeService instance;

    protected final PersonRepo personRepo;
    protected final RoomRepo roomRepo;
    protected final LayoutRepo layoutRepo;

    @Autowired
    public UserModeService(PersonRepo personRepo, RoomRepo roomRepo, LayoutRepo layoutRepo) {
        this.personRepo = personRepo;
        this.roomRepo = roomRepo;
        this.layoutRepo = layoutRepo;
        UserModeService.instance = this;
    }

    public static UserModeService getInstance() {
        assert instance != null;
        return instance;
    }

    private boolean isUserAuthenticatable(Person user) {
        return user != null && user.getPasswordHash() != null;
    }
    
    public Person authenticateUser(Person user) {
        Person personWithEmail = getUserWithEmail(user.getEmail());

        if (isUserAuthenticatable(user)) {
            if (personWithEmail.isCredentialsValid(user)) {
                try {
                    Person.generateAuthToken(personWithEmail);
                    return personWithEmail;
                } catch (Exception ignored) {}
            }
        }

        return null;
    }

    public Person getUserWithEmail(String email) {
        Person personWithEmail = null;
        for (Person p : personRepo.findAll()) {
            if (p.getEmail().equals(email)) {
                personWithEmail = p;
                break;
            }
        }
        return personWithEmail;
    }

    public Room[] getRooms() {
        return StreamSupport.stream(roomRepo.findAll().spliterator(), false).toArray(Room[]::new);
    }

    protected Person getPersonById(int id) {
        return personRepo.findById(id).orElse(null);
    }

    protected Room getRoomById(int id) {
        return roomRepo.findById(id).orElse(null);
    }

    public boolean reserveRoom(int person_id, int room_id) {
        Person person = getPersonById(person_id);
        Room room = getRoomById(room_id);

        if (person == null || room == null) return false;

        Layout layout = person.getLayout();
        if (layout != null && room.equals(layout.getRoom())) return true;

        synchronized (LayoutRepo.synchronizationObject) {
            if (room.getLayouts().size() == room.getCapacity()) return false;
            if (!room.getType().isGenderAllowed(person.getGender())) return false;

            if (layout != null) cancelReservation(person_id);
            layout = new Layout(person, room);
            layoutRepo.save(layout);
        }

        return true;
    }

    public Layout getReservation(int person_id) {
        Person person = getPersonById(person_id);
        if (person == null) return null;

        return person.getLayout();
    }

    public boolean cancelReservation(int person_id) {
        Layout reservation = getReservation(person_id);

        if (reservation.getRoom().getLayouts().size() == 1) {
            reservation.getRoom().setType(RoomType.MIXED);
            roomRepo.save(reservation.getRoom());
        }
        layoutRepo.delete(reservation);

        return true;
    }

    public boolean setRoomType(int person_id, RoomType type) {
        Layout reservation = getReservation(person_id);

        for (Layout l : reservation.getRoom().getLayouts()) {
            if (!type.isGenderAllowed(l.getPerson().getGender())) return false;
        }

        reservation.getRoom().setType(type);
        roomRepo.save(reservation.getRoom());

        return true;
    }
}
