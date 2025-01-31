package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table( name="car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name="couleur")
    private String color;
    @ManyToOne
    @JoinColumn( name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "car_features",
            joinColumns = @JoinColumn(name ="car_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<Feature> features;

    public Car(String color, User user){
        this.color = color;
        this.user = user;
    }
}
