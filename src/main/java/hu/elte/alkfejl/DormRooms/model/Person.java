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
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String neptunId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean newbie;

    @Column(nullable = false)
    private String passwordSalt;

    @Column
    private String passwordHash;

    @Column
    private String authToken;

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
    @ToString.Exclude
    private List<Label> labels;


    private static String generateInviteToken() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] inviteTokenRawBytes = new byte[64];
        DormRoomsApplication.globalSecureRandomGenerator.nextBytes(inviteTokenRawBytes);
        return new String(Base64.encodeBase64(md.digest(inviteTokenRawBytes)));
    }

    private static String generatePasswordSalt() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] passwordSaltRawBytes = new byte[32];
        DormRoomsApplication.globalSecureRandomGenerator.nextBytes(passwordSaltRawBytes);
        return new String(Base64.encodeBase64(md.digest(passwordSaltRawBytes)));
    }

    public static void prepareNewPerson(Person person) throws NoSuchAlgorithmException {
        person.inviteToken = generateInviteToken();
        person.passwordSalt = generatePasswordSalt();
    }

    public static void generateAuthToken(Person person) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] inviteTokenRawBytes = new byte[64];
        DormRoomsApplication.globalSecureRandomGenerator.nextBytes(inviteTokenRawBytes);
        person.authToken = new String(Base64.encodeBase64(md.digest(inviteTokenRawBytes)));
    }

    // boilerplate
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getAuthToken() { return authToken; }

    public String getInviteToken() {
        return inviteToken;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
    }

    public boolean isCredentialsValid(Person user) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        byte[] pwSaltBytes = user.passwordSalt.getBytes();
        byte[] pwBytes = user.passwordHash.getBytes();
        byte[] pwBytesUnion = new byte[pwBytes.length + pwSaltBytes.length];
        for (int i = 0; i<pwSaltBytes.length; ++i) pwBytesUnion[i] = pwSaltBytes[i];
        for (int i = 0, j = pwSaltBytes.length; i < pwBytes.length; ++i, ++j) pwBytesUnion[j] = pwBytes[i];
        String pw = new String(Base64.encodeBase64(md.digest(pwBytesUnion)));
        return this.passwordHash.equals(pw);
    }

    public void removeLayout() {
        layout = null;
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
        if (labels.contains(label)) {
            labels.remove(label);
        }
    }
}