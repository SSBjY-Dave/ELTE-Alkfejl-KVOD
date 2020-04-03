package hu.elte.alkfejl.DormRooms.controller;

import hu.elte.alkfejl.DormRooms.model.Person;
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
        AdminModeService ums = AdminModeService.getInstance();
        return ums.addPerson(p);
    }
}
