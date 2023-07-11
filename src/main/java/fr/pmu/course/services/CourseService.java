package fr.pmu.course.services;

import fr.pmu.course.dtos.CourseRequest;
import fr.pmu.course.dtos.CourseResponse;

import java.util.List;

public interface CourseService
{
    CourseResponse findById(Long courseId);

    List<CourseResponse> findAll();

    CourseResponse save(CourseRequest request);

    //TODO Décricre les autres méthodes : findByCourseNumber, findByCourseName ....
}
