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
                    personRepo.save(personWithEmail);
                    return personWithEmail;
                } catch (Exception ignored) {}
            }
        }

        return null;
    }

    public Person getUserWithEmail(String email) {
        if (email == null || email.length() == 0) return null;
        Person personWithEmail = null;
        for (Person p : personRepo.findAll()) {
            if (p.getEmail().equals(email)) {
                personWithEmail = p;
                break;
            }
        }
        return personWithEmail;
    }

    public Person getUserByAuthToken(String authToken) {
        if (authToken == null || authToken.length() == 0) return null;
        Person personWithAuthToken = null;
        for (Person p : personRepo.findAll()) {
            if (p.getAuthToken() != null && p.getAuthToken().equals(authToken)) {
                personWithAuthToken = p;
                break;
            }
        }
        return personWithAuthToken;
    }
}
