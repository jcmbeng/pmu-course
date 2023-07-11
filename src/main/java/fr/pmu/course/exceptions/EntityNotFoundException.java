package fr.pmu.course.exceptions;

import lombok.Getter;

import java.util.List;

public class EntityNotFoundException extends RuntimeException
{




    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
