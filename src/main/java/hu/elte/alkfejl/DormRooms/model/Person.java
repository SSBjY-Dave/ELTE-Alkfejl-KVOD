package hu.elte.alkfejl.DormRooms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hu.elte.alkfejl.DormRooms.DormRoomsApplication;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "person")
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    @Column(nullable = true)
    private String passwordHash;

    @Column(nullable = false)
    private String inviteToken;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "resident_id")
    private Layout layout;

    @ToString.Exclude
    @JsonSerialize(using = AdminFieldSerializer.class)
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "person_id")
    private Admin admin;

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

    public String getInviteToken() {
        return inviteToken;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
    }
}

class AdminFieldSerializer extends JsonSerializer<Admin> {

    @Override
    public void serialize(Admin admin, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeBoolean(admin != null);
    }
}