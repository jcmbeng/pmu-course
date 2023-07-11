package fr.pmu.course.repositories;

import fr.pmu.course.models.Partant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartantRepository extends JpaRepository<Partant, Long> {
}
