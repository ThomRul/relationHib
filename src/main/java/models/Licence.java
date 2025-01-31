package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "licence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Licence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;
    @OneToOne(mappedBy = "license")
    private User user;

    // Côté inverse de la relation, fait référence au champ 'license' dans User

    public Licence(String number) {
        this.number = number;
    }
}
