package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.Room;
import hu.elte.alkfejl.DormRooms.model.RoomType;
import hu.elte.alkfejl.DormRooms.service.UserModeService;
import javafx.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "HOME PAGE....";
    }

    @PostMapping("/authenticate")
    public Person authenticateUser(@RequestBody Person p) {
        UserModeService ums = UserModeService.getInstance();
        return ums.authenticateUser(p);
    }

    @PostMapping("/getUserWithEmail")
    public Person getUserWithEmail(@RequestBody Map<String, String> emailJSON) {
        UserModeService ums = UserModeService.getInstance();
        String email = emailJSON.get("email");
        return (email != null) ? ums.getUserWithEmail(emailJSON.get("email")) : null;
    }

    @PostMapping("/getRooms")
    public Room[] getRooms() {
        UserModeService ums = UserModeService.getInstance();
        return ums.getRooms();
    }

    @PostMapping("/reserveRoom")
    public boolean reserveRoom(int person_id, int room_id) {
        UserModeService ums = UserModeService.getInstance();
        return ums.reserveRoom(person_id, room_id);
    }

    @PostMapping("/cancelReservation")
    public boolean cancelReservation(int person_id) {
        UserModeService ums = UserModeService.getInstance();
        return ums.cancelReservation(person_id);
    }

    @PostMapping("/setRoomType")
    public boolean setRoomType(int person_id, RoomType type) {
        UserModeService ums = UserModeService.getInstance();
        return ums.setRoomType(person_id, type);
    }
}
