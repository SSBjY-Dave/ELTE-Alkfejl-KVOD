package hu.elte.alkfejl.DormRooms.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String text;

    @ManyToMany(mappedBy = "labels")
    @ToString.Exclude
    private List<Person> persons;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String label) {
        this.text = label;
    }
}
