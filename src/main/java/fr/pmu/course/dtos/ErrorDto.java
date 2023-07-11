package fr.pmu.course.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

  private Integer statusCode;

  private String message;

  private List<String> errors = new ArrayList<>();

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Instant responseTime;

}
