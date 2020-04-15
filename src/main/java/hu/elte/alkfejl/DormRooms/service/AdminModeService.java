package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.*;
import hu.elte.alkfejl.DormRooms.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class AdminModeService extends UserModeService {
    private static AdminModeService instance;
    protected final LabelRepo labelRepo;

    @Autowired
    protected AdminModeService(PersonRepo personRepo, RoomRepo roomRepo, LayoutRepo layoutRepo, LabelRepo labelRepo, BCryptPasswordEncoder passwordEncoder, AuthenticatedUser user) {
        super(personRepo, roomRepo, layoutRepo, passwordEncoder, user);
        this.labelRepo = labelRepo;
        AdminModeService.instance = this;
    }

    public static AdminModeService getInstance() {
        assert instance != null;
        return instance;
    }

    public Room getRoomById(int id) {
        return roomRepo.findById(id).orElse(null);
    }

    public Label getLabelById(int id) {
        return labelRepo.findById(id).orElse(null);
    }

    public Label[] getLabels() {
        return (Label[]) StreamSupport.stream(labelRepo.findAll().spliterator(), false).toArray();
    }

    public Person addPerson(Person person) {
        if (personRepo.findByEmail(person.getEmail()).isPresent()) return null;

        person.setRole(Role.RESIDENT);
        return personRepo.save(person);
    }

    public Person updatePerson(Person person) {
        if (personRepo.findByEmail(person.getEmail()).isEmpty()) return null;
        return personRepo.save(person);
    }

    public boolean deletePerson(Person person) {
        if (person == null) return false;

        personRepo.delete(person);
        return true;
    }

    public boolean forceReserve(Person person, Room room) {
        return reserveRoom(person, room);
    }

    public boolean forceRemoveReservation(Person person) {
        return cancelReservation(person);
    }

    public boolean forceRoomType(Room room, RoomType type) {
        return setRoomType(room, type);
    }

    public boolean setRoomCapacity(Room room, int capacity) {
        if (room == null || !roomRepo.existsById(room.getId()) || room.getLayouts().size() > capacity) return false;

        room.setCapacity(capacity);
        roomRepo.save(room);
        return true;
    }

    public boolean setRoomState(Room room, RoomState state) {
        if (room == null || !roomRepo.existsById(room.getId()) || state == null) return false;

        room.setState(state);
        roomRepo.save(room);
        return true;
    }

    public boolean addLabel(String text) {
        if (labelRepo.findLabelByText(text).isPresent()) return false;

        Label newLabel = new Label();
        newLabel.setText(text);
        labelRepo.save(newLabel);
        return true;
    }

    public boolean deleteLabel(Label label) {
        if (label == null) return false;

        labelRepo.delete(label);
        return true;
    }

    public boolean modifyLabel(Label label, String text) {
        if (label == null || labelRepo.findLabelByText(text).isPresent() || text == null || text.isBlank()) return false;

        label.setText(text);
        labelRepo.save(label);
        return true;
    }

    public boolean assignLabelToPerson(Person person, Label label) {
        if (person == null || personRepo.existsById(person.getId()) || label == null || labelRepo.existsById(label.getId())) return false;

        person.addLabel(label);
        personRepo.save(person);
        return true;
    }

    public boolean removeLabelFromPerson(Person person, Label label) {
        if (person == null || personRepo.existsById(person.getId()) || label == null || labelRepo.existsById(label.getId())) return false;

        person.removeLabel(label);
        return true;
    }
}
