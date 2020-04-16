package hu.elte.alkfejl.DormRooms.model;

import com.fasterxml.jackson.annotation.*;
import hu.elte.alkfejl.DormRooms.DormRoomsApplication;
import lombok.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String neptunId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean newbie;

    @Column
    private String password;

    @Column(nullable = false)
    private String inviteToken;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @OneToOne(mappedBy = "person")
    @ToString.Exclude
    private Layout layout;

    @ManyToMany
    @JoinTable
    private List<Label> labels;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNeptunId() {
        return neptunId;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNewbie() {
        return newbie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInviteToken() {
        return inviteToken;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
    }

    public Gender getGender() {
        return gender;
    }

    public void addLabel(Label label) {
        if (!labels.contains(label)) {
            labels.add(label);
        }
    }

    public void removeLabel(Label label) {
        labels.remove(label);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}