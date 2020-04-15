package hu.elte.alkfejl.DormRooms.model;

import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PersonRepo extends CrudRepository<Person, Integer> {
    Optional<Person> findByEmail(String email);
    Optional<Person> findByInviteToken(String inviteToken);
}
