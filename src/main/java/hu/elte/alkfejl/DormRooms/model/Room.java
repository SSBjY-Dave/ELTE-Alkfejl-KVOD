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
    private List<Layout> layouts;

    @Enumerated(EnumType.STRING)
    private RoomState state;

    @Enumerated(EnumType.STRING)
    private RoomType type;

}
