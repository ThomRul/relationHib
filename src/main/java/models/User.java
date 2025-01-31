package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Hibernate via jakarta
@Entity // Je viens de dire à mon ORM hibernate, écoute quand tu lances, le code, crée user.
@Table(name = "\"user\"")

// Lombok
@Getter // crée par défaut pour tous les attributs de ma classe, un getter
@Setter // crée par défaut pour tous les attributs de ma classe, un setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name="name")
    private String name;

}
