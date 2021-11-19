package es.upm.agile.entrepreneursideamanager.controllers.rest;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping("/api/v1")
public @interface V1APIController {
  @AliasFor(annotation = RestController.class)
  String value() default "";
}
