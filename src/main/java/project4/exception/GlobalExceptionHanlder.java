package project4.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHanlder {

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public void handlingValidation(MethodArgumentNotValidException e ) {
//        throw new RuntimeException();
//    }
}
