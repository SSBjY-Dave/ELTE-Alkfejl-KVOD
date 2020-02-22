package hu.elte.alkfejl.DormRooms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int roomNumber;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "room_id")
    private Layout layout;
}
