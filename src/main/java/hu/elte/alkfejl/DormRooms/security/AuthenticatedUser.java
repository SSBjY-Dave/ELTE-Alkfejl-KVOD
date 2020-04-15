package hu.elte.alkfejl.DormRooms.security;

import hu.elte.alkfejl.DormRooms.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    private Person user;

    public void setUser(Person user) {
        this.user = user;
    }

    public Person getUser() {
        return user;
    }
}
