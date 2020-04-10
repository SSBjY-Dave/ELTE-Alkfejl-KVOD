package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.RoomState;
import hu.elte.alkfejl.DormRooms.model.RoomType;
import hu.elte.alkfejl.DormRooms.service.AdminModeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {
    @PostMapping("/addPerson")
    public Person addPerson(Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.addPerson(p);
    }

    @PostMapping("/updatePerson")
    public Person updatePerson(Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.updatePerson(p);
    }

    @PostMapping("/deletePerson")
    public boolean deletePerson(Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.deletePerson(p);
    }

    @PostMapping("/forceReserve")
    public boolean forceReserve(int person_id, int room_id) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceReserve(person_id, room_id);
    }

    @PostMapping("/forceRemoveReservation")
    public boolean forceRemoveReservation(int person_id) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceRemoveReservation(person_id);
    }

    @PostMapping("/forceRoomType")
    public boolean forceRoomType(int room_id, RoomType type) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceRoomType(room_id, type);
    }

    @PostMapping("/setRoomCapacity")
    public boolean setRoomCapacity(int room_id, int capacity) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.setRoomCapacity(room_id, capacity);
    }

    @PostMapping("/setRoomState")
    public boolean setRoomState(int room_id, RoomState state) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.setRoomState(room_id, state);
    }

    @PostMapping("/addLabel")
    public boolean addLabel(String label) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.addLabel(label);
    }

    @PostMapping("/deleteLabel")
    public boolean deleteLabel(int label_id) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.deleteLabel(label_id);
    }

    @PostMapping("/modifyLabel")
    public boolean modifyLabel(int label_id, String newLabel) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.modifyLabel(label_id, newLabel);
    }

    @PostMapping("/assignLabelToPerson")
    public boolean assignLabelToPerson(int person_id, int label_id) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.assignLabelToPerson(person_id, label_id);
    }

    @PostMapping("/removeLabelFromPerson")
    public boolean removeLabelFromPerson(int person_id, int label_id) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.removeLabelFromPerson(person_id, label_id);
    }
}
