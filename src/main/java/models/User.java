package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// Hibernate via jakarta
@Entity // Je viens de dire à mon ORM hibernate, écoute quand tu lances, le code, crée user.
@Table(name = "\"user\"")

// Lombok
@Getter // crée par défaut pour tous les attributs de ma classe, un getter
@Setter // crée par défaut pour tous les attributs de ma classe, un setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name="name")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Car> cars;

    public User(String name){
        this.name = name;
        this.cars = new ArrayList<>();
    }

}
