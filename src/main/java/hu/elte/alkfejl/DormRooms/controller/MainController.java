package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.service.UserModeService;
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
}
