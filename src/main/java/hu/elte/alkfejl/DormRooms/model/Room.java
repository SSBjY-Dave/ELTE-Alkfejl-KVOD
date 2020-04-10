package hu.elte.alkfejl.DormRooms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int room_number;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    private List<Layout> layouts;

    @Enumerated(EnumType.STRING)
    private RoomState state;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    public Layout getPersonReservation(Person p) {
        for (Layout l : layouts) {
            if (l.getPerson().equals(p)) {
                return l;
            }
        }

        return null;
    }

    // boilerplate
    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public int getRoomNumber() {
        return room_number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Layout> getLayouts() {
        return layouts;
    }

    public RoomState getState() {
        return state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public RoomType getType() {
        return type;
    }

    public void removeLayout(Layout layout) {
        layouts.remove(layout);
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
