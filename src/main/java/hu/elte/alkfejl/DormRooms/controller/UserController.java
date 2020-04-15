package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.Room;
import hu.elte.alkfejl.DormRooms.model.RoomType;
import hu.elte.alkfejl.DormRooms.security.AuthenticatedUser;
import hu.elte.alkfejl.DormRooms.service.UserModeService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
    @PostMapping("/user/getRooms")
    public Room[] getRooms() {
        UserModeService ums = UserModeService.getInstance();
        return ums.getRooms();
    }

    @PostMapping("/user/reserveRoom/room")
    public boolean reserveRoom(@RequestBody Room room) {
        UserModeService ums = UserModeService.getInstance();
        return ums.reserveRoom(room);
    }

    @PostMapping("/user/cancelReservation")
    public boolean cancelReservation() {
        UserModeService ums = UserModeService.getInstance();
        return ums.cancelReservation();
    }

    @PostMapping("/user/setRoomType/")
    public boolean setRoomType(@RequestBody RoomType type) {
        UserModeService ums = UserModeService.getInstance();
        return ums.setRoomType(type);
    }
}
