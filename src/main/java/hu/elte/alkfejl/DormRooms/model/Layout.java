package hu.elte.alkfejl.DormRooms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "layout")
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected int id;

    @Column(name = "room_id", nullable = false)
    private int roomId;

    @Column(name = "resident_id", nullable = false)
    private int residentId;
}
