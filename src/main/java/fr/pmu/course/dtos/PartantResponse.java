package fr.pmu.course.dtos;

import fr.pmu.course.models.Partant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PartantResponse
{
    private String name;

    private int number;


    public static PartantResponse fromEntityToResponse(Partant partant)
    {
        if (partant == null) {
            //TODO Une exceprion doit être levée si l'entité "partant" est nulle
            return null;
        }

        return PartantResponse
                .builder()
                .name(partant.getName())
                .number(partant.getPartantNumber())
                .build();
    }
}
