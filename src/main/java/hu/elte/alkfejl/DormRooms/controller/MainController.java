package hu.elte.alkfejl.DormRooms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class MainController {
    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/")
    public String homePage() {
        return "HOME PAGE....";
    }

    @GetMapping("/date")
    public String getDate() {
        Date d = new Date();
        return "{ \"time\": " + (d.getTime()) + " }";
    }

    @PostMapping("/addPerson")
    public String addPerson(Person p) {
        try {
            Person.prepareNewPerson(p);
            personRepo.save(p);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return p.toString();
    }

    @PostMapping("/getUserWithEmail")
    public Person getUserWithEmail(@RequestBody Map<String, String> data) {
        Person user = null;
        for (Person p : personRepo.findAll()) {
            if (p.getEmail().equals(data.get("email"))) user = p;
        }

        return user;
    }
}
