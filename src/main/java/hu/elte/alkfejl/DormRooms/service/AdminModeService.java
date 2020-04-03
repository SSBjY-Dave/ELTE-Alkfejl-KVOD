package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminModeService extends UserModeService {
    private static AdminModeService instance;

    @Autowired
    public AdminModeService(PersonRepo personRepo) {
        super(personRepo);
        AdminModeService.instance = this;
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
}
