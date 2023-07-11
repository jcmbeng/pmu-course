package fr.pmu.course.validators;

import fr.pmu.course.dtos.CourseRequest;

import java.util.ArrayList;
import java.util.List;

public class CourseValidator {
    /**
     * Cette méthode prend en paramètre une requête <b>CourseRequest</b> et valide ses champs
     * @param courseRequest <b>CourseRequest</b> - Requête avec de données soumise coté front-end
     * @return Un tableau avec des éléments si des erreurs ont été trouvées sinon un tableau vide
     */
    public static List<String> validate(CourseRequest courseRequest){
        List<String> errors = new ArrayList<>();

        if(courseRequest == null)
        {
            errors.add("Veuillez renseigner toutes les informations sur la course (*)");
            return  errors;
        }

        if(courseRequest.getRaceDate() == null)
        {
            errors.add("Veuillez renseigner la date de la course (*)");
        }

        if(courseRequest.getName() ==null || courseRequest.getName().isBlank())
        {
            errors.add("Veuillez renseigner le nom de la course (*)");
        }

        if(courseRequest.getPartants() ==null || courseRequest.getPartants().size()<3)
        {
            errors.add("Une course doit avoir au moins 3 partants (*)");
        }

        return  errors;
    }
}
