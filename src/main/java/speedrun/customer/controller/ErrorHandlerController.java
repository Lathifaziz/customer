package speedrun.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import speedrun.customer.utill.response.Res;

@RestControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerConstraintViolation(MethodArgumentNotValidException e){
        return Res.renderJson(null,e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
