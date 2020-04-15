package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.*;
import hu.elte.alkfejl.DormRooms.service.AdminModeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {
    @PostMapping("/admin/addPerson")
    public Person addPerson(@RequestBody Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.addPerson(p);
    }

    @PostMapping("/admin/updatePerson")
    public Person updatePerson(@RequestBody Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.updatePerson(p);
    }

    @PostMapping("/admin/deletePerson")
    public boolean deletePerson(@RequestBody Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.deletePerson(p);
    }

    @PostMapping("/admin/forceReserve/{room}")
    public boolean forceReserve(@PathVariable("room") int room_id, @RequestBody Person person) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceReserve(person, ams.getRoomById(room_id));
    }

    @PostMapping("/admin/forceRemoveReservation")
    public boolean forceRemoveReservation(@RequestBody Person p) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceRemoveReservation(p);
    }

    @PostMapping("/admin/forceRoomType/{room}")
    public boolean forceRoomType(@PathVariable("room") int room, @RequestBody RoomType type) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.forceRoomType(ams.getRoomById(room), type);
    }

    @PostMapping("/admin/setRoomCapacity/{room}")
    public boolean setRoomCapacity(@PathVariable("room") int room, @RequestBody int capacity) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.setRoomCapacity(ams.getRoomById(room), capacity);
    }

    @PostMapping("/admin/setRoomState/{room}")
    public boolean setRoomState(@PathVariable("room") int room, @RequestBody RoomState state) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.setRoomState(ams.getRoomById(room), state);
    }

    @PostMapping("/admin/addLabel")
    public boolean addLabel(@RequestBody String label) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.addLabel(label);
    }

    @PostMapping("/admin/deleteLabel")
    public boolean deleteLabel(@RequestBody Label label) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.deleteLabel(label);
    }

    @PostMapping("/admin/modifyLabel/{label}")
    public boolean modifyLabel(@PathVariable("label") int label, String text) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.modifyLabel(ams.getLabelById(label), text);
    }

    @PostMapping("/admin/assignLabelToPerson/{label}")
    public boolean assignLabelToPerson(@PathVariable("label") int label, @RequestBody Person person) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.assignLabelToPerson(person, ams.getLabelById(label));
    }

    @PostMapping("/admin/removeLabelFromPerson/{label}")
    public boolean removeLabelFromPerson(@PathVariable("label") int label, @RequestBody Person person) {
        AdminModeService ams = AdminModeService.getInstance();
        return ams.removeLabelFromPerson(person, ams.getLabelById(label));
    }
}
