package fr.pmu.course.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.pmu.course.models.Course;
import fr.pmu.course.models.Partant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseRequest {
    private String name;

    private Date raceDate;

    Set<String> partants;

    @JsonIgnore
    List<Partant>  partantList;


    private String raceNumber;

    public static Course fromRequestToEntity(CourseRequest request) {
        if (request == null) {
            //TODO Throws an exception if the passed request is null
            return null;
        }



        return Course
                .builder()
                .name(request.getName())
                .raceDate(request.getRaceDate())
                .raceNumber(request.getRaceNumber())
                .partants(request.getPartantList())
                .build();
    }
}
