package fr.pmu.course.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.pmu.course.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseResponse
{
    private Long id;

    private String name;

    private  String  raceNumber;


    private Date raceDate;

    private List<PartantResponse> partants;


    /**
     *
     * @param course Objet de type course trouvé dans la Base de donnée
     * @return Objet de type CourseResponse
     */
    public static CourseResponse fromEntityToResponse(Course course)
    {
        if (course == null) {
            //TODO Une exceprion doit être levée si l'entité "course" est nulle
            return null;
        }

        return CourseResponse
                .builder()
                .id(course.getId())
                .name(course.getName())
                .raceNumber(course.getRaceNumber())
                .raceDate(course.getRaceDate())
                .partants(course.getPartants()
                        .stream()
                        .map(PartantResponse::fromEntityToResponse)
                        .toList())
                .build();
    }
}
