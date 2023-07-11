package fr.pmu.course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import fr.pmu.course.models.Course;
import fr.pmu.course.models.Partant;
import fr.pmu.course.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CourseRepositoryUnitTests
{
    @Autowired
    private CourseRepository courseRepository;



    @Test
    public void saveShouldCreateANewCourse() {
        // Given
        final List<Partant> partants = new ArrayList<>();

        Course course = new Course();
        course.setName("NEW-COURSE");
        course.setRaceNumber("RACE2");
        course.setRaceDate(new Date());

        for(int i = 0; i<5; i++)
        {
            partants.add(
                    Partant
                            .builder()
                            .course(course)
                            .partantNumber(2)
                            .name("NOM-PARTANT-" + i)
                            .build()
            );
        }

        course.setPartants(partants);

        // When
        Course course1 = this.courseRepository.save(course);
        // Then
        assertNotNull(course);
        assertThat(course.getId()).isGreaterThan(0);

    }

    @Test
    void shouldReturnACourse()
    {
        //When
        Optional<Course> optionalCourse = courseRepository.findById(Long.valueOf(1));

        // Then
        assertTrue(optionalCourse.isPresent());
    }

    @Test
    void findAllShouldReturnCoursesList() {
        // When
        List<Course> courses = courseRepository.findAll();
        // Then
        assertThat(courses.size()).isGreaterThan(0);
    }
}
