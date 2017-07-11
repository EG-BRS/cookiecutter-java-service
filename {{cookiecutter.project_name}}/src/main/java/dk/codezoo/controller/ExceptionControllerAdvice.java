package dk.codezoo.controller;

import dk.codezoo.common.service.mapping.RestErrorExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice()
public class ExceptionControllerAdvice extends RestErrorExceptionHandler {

    
}
