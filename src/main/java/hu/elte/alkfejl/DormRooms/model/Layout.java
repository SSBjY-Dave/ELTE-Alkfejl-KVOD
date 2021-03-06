package hu.elte.alkfejl.DormRooms.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Layout(Person person, Room room) {
        this.person = person;
        this.room = room;
    }

    // boilerplate
    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Person getPerson() {
        return person;
    }
}
