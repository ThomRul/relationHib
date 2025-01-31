## Relations :
###Many To One
Un utilisateur peut avoir plusieurs voitures
Une voiture appartient à UN SEUL utilisateur
@OneToMany (coté ONE) --> Un utilisateur à plusieurs voitures
@ManyToOne (coté MANY) ---> Plusieurs voitures APPARTIENNENT à un utilisateur
Comment déterminer de quel coté mettre les annotation (@ManyToOne - @OneToMany)
"EST CE QUE X PEUT AVOIR PLUSIEURS Y" --> ONE TO MANY
"EST CE QUE PLUSIEURS Y APPARTIENNENT A UN SEUL X" --> MANY TO ONE

### MANY TO MANY
exemple un étudiant pourrait suivre plusieurs cours
Un cours est suivi par plusieurs étudiants

Etudiant (@ManyToMany) <- -> Cours(@ManyToMany)

### ONE TO ONE
Exemple un user qui a une carte d'identité
user (@OneToOne) carte_id(@OneToOne)

## Règles
On conseille toujours d'avoir des relations unidirectionnelles (mais pour les exemples on travaillera avec la bidirectionnalité)
Dans une relation bidirectionnelle les deux entité on connaisance de la relation
Il y aura TOUJOURS (bi)
Le côté propriétaire de la relation --> C'est lui qui contient la clef étrangère
De l'autre côté on aura une référence via un MappedBy
### Règle D'or
Coté Many -> toujours le propriétaire dans la relation
Coté ONE -> il aura toujours le mapped BY

### ONE TO MANY - MANY TO ONE
````Java
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Car {
    @ManyToOne
    @JoinColumn(name = 'user_id') // spécifier la clef étrangère
    private User user;
}

@Entity
public class User {
    @OneToMany(mappedBy="user")
    private List<Car> cars; // il fait référence au champ user qu'il y a dans Car
}

````
### MANY TO MANY
n'importe quel côté peut être propriétaire

````java
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;

@Entity
public class Student {
    @ManyToMany
    @JoinTable(name = "student_cours")
    private List<Cours> cours;

}

@Entity
public class cours {
    @ManyToMany(mappedBy = "cours")
    private List<Student> students;

}

````

### ONE TO ONE
Pour déterminer le côté propriétaire il faut réfléchir à la relation --> Quelle est l'entité qui a le "plus" besoin de l'autre

````java
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import models.Car;

@Entity
public class CarteId {
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

@Entity
public class Person {
    @OneToOne(mappedBy = "person")
    private CarteId carteId;
}

````
