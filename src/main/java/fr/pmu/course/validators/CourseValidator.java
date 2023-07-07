package com.wikiemploi.jobs.validators;

import com.wikiemploi.jobs.dtos.JobRequest;

import java.util.ArrayList;
import java.util.List;

public class JobValidator {
    /**
     * Cette méthode prend en paramètre une requête <b>JobRequest</b> et valide ses champs
     * @param jobRequest <b>JobRequest</b> - Requête généralement soumise coté front-end
     * @return Un tableau avec des éléments si des erreurs ont été trouvées sinon un tableau vide
     */
    public static List<String> validate(JobRequest jobRequest){
        List<String> errors = new ArrayList<>();

        if(jobRequest == null)
        {
            errors.add("Veuillez renseigner toutes les information sur la catégorie (*)");
            return  errors;
        }

        if(jobRequest.getTitle().isBlank())
        {
            errors.add("Veuillez renseigner le nom du produit (*)");
        }

        return  errors;
    }
}
