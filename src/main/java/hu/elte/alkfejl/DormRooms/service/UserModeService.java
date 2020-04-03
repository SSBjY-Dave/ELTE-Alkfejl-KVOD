package hu.elte.alkfejl.DormRooms.service;

import hu.elte.alkfejl.DormRooms.model.Person;
import hu.elte.alkfejl.DormRooms.model.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserModeService {
    protected final PersonRepo personRepo;
    private static UserModeService instance;

    @Autowired
    public UserModeService(PersonRepo personRepo) {
        this.personRepo = personRepo;
        UserModeService.instance = this;
    }

    public static UserModeService getInstance() {
        return instance;
    }

    private boolean isUserAuthenticatable(Person user) {
        return user != null && user.getPasswordHash() != null;
    }
    
    public Person authenticateUser(Person user) {
        Person personWithEmail = getUserWithEmail(user.getEmail());

        if (isUserAuthenticatable(user)) {
            if (personWithEmail.isCredentialsValid(user)) {
                try {
                    Person.generateAuthToken(personWithEmail);
                    return personWithEmail;
                } catch (Exception ignored) {}
            }
        }

        return null;
    }

    public Person getUserWithEmail(String email) {
        Person personWithEmail = null;
        for (Person p : personRepo.findAll()) {
            if (p.getEmail().equals(email)) {
                personWithEmail = p;
                break;
            }
        }
        return personWithEmail;
    }
}
