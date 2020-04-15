package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.Room;
import hu.elte.alkfejl.DormRooms.model.RoomType;
import hu.elte.alkfejl.DormRooms.service.AdminModeService;
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

    @GetMapping("/error")
    public String errorPage() {
        return "ERROR";
    }

    @PostMapping("/authenticate")
    public boolean authenticateUser() {
        return true;
    }
}
