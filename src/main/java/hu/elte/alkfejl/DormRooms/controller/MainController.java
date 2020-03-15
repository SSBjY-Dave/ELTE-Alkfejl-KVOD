package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
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
    public Person getUserWithEmail(@RequestBody String email) {
        UserModeService ums = UserModeService.getInstance();
        return ums.getUserWithEmail(email);
    }

    @PostMapping("/isAuthTokenValid")
    public boolean isAuthTokenValid(@RequestBody String authToken) {
        UserModeService ums = UserModeService.getInstance();
        return ums.getUserByAuthToken(authToken) != null;
    }

    @PostMapping("/getUserByAuthToken")
    public Person getUserByAuthToken(@RequestBody String authToken) {
        UserModeService ums = UserModeService.getInstance();
        return ums.getUserByAuthToken(authToken);
    }
}
