package fr.pmu.course.handlers;

import fr.pmu.course.dtos.ErrorDto;
import fr.pmu.course.exceptions.EntityNotFoundException;
import fr.pmu.course.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .statusCode(notFound.value())
                .message(exception.getMessage())
                .responseTime(Instant.now())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }


    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        exception.printStackTrace();
        final ErrorDto errorDto = ErrorDto.builder()
                .statusCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .responseTime(Instant.now())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }

   }
