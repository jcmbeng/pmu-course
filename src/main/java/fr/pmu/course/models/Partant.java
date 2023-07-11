package fr.pmu.course.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "partant")
public class Partant
{
    /**
     * Clé primaire, identifiant unique de l'objet Partant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nom du partant
     */
    private String name;

    /**
     * Numéro du partant dans la course
     */
    private int partantNumber;


    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

}
