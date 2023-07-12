package fr.pmu.course.controllers;


import fr.pmu.course.dtos.CourseRequest;
import fr.pmu.course.dtos.CourseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "${course.api.name}", description = "${course.api.description}")
@RequestMapping("${course.api.url-root-mapping}/courses")
public interface ApiCourse
{
    @Operation(
            summary = "Récupère une Course avec son Id",
            description = "Cette méthode récupère une Course de la base de données grace à son Id et expose une réponse contenant les Partants associés")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    ResponseEntity<CourseResponse> findById(@PathVariable(name = "id") Long id);

   @Operation(
            summary = "Récupère toutes les courses",
            description = "Cette méthode récupère toutes les courses de la base de données grace à son Id et expose une réponse contenant les Partants associés"
    )
   @ResponseStatus(HttpStatus.OK)
   @GetMapping("")
   ResponseEntity<List<CourseResponse>> findByAll();

    @Operation(
            summary = "Création d'une nouvelle course",
            description = "Cette méthode permet la création d'une nouvelle course"
    )

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    ResponseEntity<CourseResponse> save(@RequestBody CourseRequest request);


}
