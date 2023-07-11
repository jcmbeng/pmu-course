package fr.pmu.course.repositories;

import fr.pmu.course.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CourseRepository extends JpaRepository<Course, Long>
{
    long countByRaceDate(Date raceDate);

}
