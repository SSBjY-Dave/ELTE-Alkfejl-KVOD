package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.*;
import hu.elte.alkfejl.DormRooms.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminModeService extends UserModeService {
    private static AdminModeService instance;
    protected final LabelRepo labelRepo;

    @Autowired
    public AdminModeService(PersonRepo personRepo, RoomRepo roomRepo, LayoutRepo layoutRepo, LabelRepo labelRepo) {
        super(personRepo, roomRepo, layoutRepo);
        AdminModeService.instance = this;
        this.labelRepo = labelRepo;
    }

    public static AdminModeService getInstance() {
        return instance;
    }

    public Person addPerson(Person p) {
        try {
            Person.prepareNewPerson(p);
            personRepo.save(p);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return p;
    }

    public Person updatePerson(Person p) {
        if (getPersonById(p.getId()) != null) {
            personRepo.save(p);
        }
        return getPersonById(p.getId());
    }

    public boolean deletePerson(Person p) {
        if (getPersonById(p.getId()) == null) return false;
        personRepo.deleteById(p.getId());
        return true;
    }

    public boolean forceReserve(int person_id, int room_id) {
        Room room = getRoomById(room_id);
        synchronized (LayoutRepo.synchronizationObject) {
            Person person = getPersonById(person_id);
            if (person.getLayout() != null) layoutRepo.delete(person.getLayout());

            if (room.getLayouts().size() >= room.getCapacity()) return false;
            Layout reservation = new Layout(person, room);
            layoutRepo.save(reservation);
        }
        return true;
    }

    public boolean forceRemoveReservation(int person_id) {
        Layout reservation = getReservation(person_id);
        if (reservation == null) return false;
        layoutRepo.delete(reservation);
        return true;
    }

    public boolean forceRoomType(int room_id, RoomType type) {
        Room room = getRoomById(room_id);
        if (room == null) return false;
        for (Layout l : room.getLayouts()) {
            if (!type.isGenderAllowed(l.getPerson().getGender())) return false;
        }
        room.setType(type);
        roomRepo.save(room);
        return true;
    }

    public boolean setRoomCapacity(int room_id, int capacity) {
        Room room = getRoomById(room_id);
        if (room.getLayouts().size() > capacity) return false;
        room.setCapacity(capacity);
        roomRepo.save(room);
        return true;
    }

    public boolean setRoomState(int room_id, RoomState state) {
        Room room = getRoomById(room_id);
        if (room == null) return false;
        room.setState(state);
        roomRepo.save(room);
        return true;
    }

    public boolean addLabel(String label) {
        for (Label l : labelRepo.findAll()) {
            if (l.getLabel().equals(label)) return false;
        }
        Label newLabel = new Label();
        newLabel.setLabel(label);
        labelRepo.save(newLabel);
        return true;
    }

    public Label getLabelById(int label_id) {
        return labelRepo.findById(label_id).orElse(null);
    }

    public boolean deleteLabel(int label_id) {
        Label label = getLabelById(label_id);
        if (label == null) return false;
        labelRepo.delete(label);
        return true;
    }

    public boolean modifyLabel(int label_id, String newLabel) {
        Label label = getLabelById(label_id);
        if (label == null) return false;
        label.setLabel(newLabel);
        labelRepo.save(label);
        return true;
    }

    public boolean assignLabelToPerson(int person_id, int label_id) {
        Person person = getPersonById(person_id);
        if (person == null) return false;

        Label label = getLabelById(label_id);
        if (label == null) return false;

        person.addLabel(label);
        return true;
    }

    public boolean removeLabelFromPerson(int person_id, int label_id) {
        Person person = getPersonById(person_id);
        if (person == null) return false;

        Label label = getLabelById(label_id);
        if (label == null) return false;

        person.removeLabel(label);
        return true;
    }
}
