package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Hibernate via jakarta
@Entity // Je viens de dire à mon ORM hibernate, écoute quand tu lances, le code, crée user.
@Table( name="\'user\'")

// Lombok
@Getter // crée par défaut pour tous les attributs de ma classe, un getter
@Setter // crée par défaut pour tous les attributs de ma classe, un setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

}
