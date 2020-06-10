package az.itstep.as.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SecurityServiceExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<?> handleConflict(RuntimeException ex, WebRequest request){
        return null;
    }


}
