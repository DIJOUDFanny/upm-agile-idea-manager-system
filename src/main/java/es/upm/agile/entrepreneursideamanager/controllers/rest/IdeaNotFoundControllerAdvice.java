package es.upm.agile.entrepreneursideamanager.controllers.rest;

import es.upm.agile.entrepreneursideamanager.IdeaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IdeaNotFoundControllerAdvice {

  @ResponseBody
  @ExceptionHandler(IdeaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String ideaNotFoundHandler(IdeaNotFoundException e) {
    return e.getMessage();
  }
}
