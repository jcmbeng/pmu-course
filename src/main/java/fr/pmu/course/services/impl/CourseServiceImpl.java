package fr.pmu.course.services.impl;

import fr.pmu.course.dtos.CourseRequest;
import fr.pmu.course.dtos.CourseResponse;
import fr.pmu.course.exceptions.EntityNotFoundException;
import fr.pmu.course.exceptions.InvalidEntityException;
import fr.pmu.course.models.Course;
import fr.pmu.course.models.Partant;
import fr.pmu.course.repositories.CourseRepository;
import fr.pmu.course.services.CourseService;
import fr.pmu.course.validators.CourseValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    /**
     * Cette varibale nous permet de manipuler l'entité Course
     */
    private final CourseRepository courseRepository;
    /**
     * Cette varibale nous permet de manipuler les Stream sur Un broker
     */
    private final StreamBridge streamBridge;

    /**
     *
     * @param courseId Id d'une course que l'on souhaite trouver dans la BD
     * @return Retourne un Objet Course si l'ID est trouvé sinon lève une exception de type EntityNotFoundException
     */
    @Override
    public CourseResponse findById(Long courseId) {
        return courseRepository.findById(courseId).map(CourseResponse::fromEntityToResponse).orElseThrow(() ->
                new EntityNotFoundException("Impossible de touver la course avec l'ID " + courseId)
        );
    }

    /**
     *
     * @return Retourne une liste d'objet Course
     */
    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(CourseResponse::fromEntityToResponse)
                .toList();
    }

    /**
     *
     * @param request Object de type CourseRequest émis depuis le Controlleur
     * @return
     */
    @Override
    public CourseResponse save(CourseRequest request) {
        List<String> errors = CourseValidator.validate(request);

        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Les données soumises sont incorrectes ", errors);
        }

        final Course course = new Course();
        AtomicInteger number = new AtomicInteger(1);
        final List<Partant> partants = new ArrayList<>();
        request.getPartants().stream().forEach(e ->
            partants.add(Partant
                    .builder()
                    .course(course)
                    .partantNumber(number.getAndIncrement())
                    .name(e)
                    .build())
        );

        course.setName(request.getName());
        course.setRaceDate(request.getRaceDate());
        course.setRaceNumber(String.valueOf(courseRepository.countByRaceDate(request.getRaceDate()) + 1));
        course.setPartants(partants);
        Course courseToSave = courseRepository.save(course);
        log.info("Course created "  + course.getName() +" - "+ course.getRaceNumber() );
        CourseResponse courseResponse = CourseResponse.fromEntityToResponse(
                courseToSave
        );
        streamBridge.send("pmu-course", courseResponse);
        log.info("Course "+ course.getName() +" - "+ course.getRaceNumber() +"sent to Broker into Topic pmu-course");
        return courseResponse;
    }
}
