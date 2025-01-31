package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "feature")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "features")
    private List<Car> cars;


    public Feature(String name) {
        this.name = name;
    }


}
