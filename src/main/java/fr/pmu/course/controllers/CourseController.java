package fr.pmu.course.controllers;


import fr.pmu.course.dtos.CourseRequest;
import fr.pmu.course.dtos.CourseResponse;
import fr.pmu.course.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController implements ApiCourse{

    private final CourseService courseService;

    @Override
    public ResponseEntity<CourseResponse> findById(Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @Override
    public ResponseEntity<List<CourseResponse>> findByAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @Override
    public ResponseEntity<CourseResponse> save(CourseRequest request) {
        return ResponseEntity.ok(courseService.save(request));
    }
}
