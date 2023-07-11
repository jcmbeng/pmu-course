package fr.pmu.course.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "course")
public class Course
{
    /**
     * Clé primaire, identifiant unique de l'objet Course
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nom de la course
     */
    private String name;

    /**
     * Jour de la course
     */

    private Date raceDate;

    /**
     * Numéro de la course pour un jour donné
     */
    private String raceNumber;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "course"
    )
    private List<Partant> partants = new ArrayList<>();
}
