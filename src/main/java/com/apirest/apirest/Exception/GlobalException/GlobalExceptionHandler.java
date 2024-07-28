package com.apirest.apirest.Exception.GlobalException;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.apirest.apirest.Exception.ExceptionClass.Error;
import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Exception.ProductoException;

@ControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(CategoriaException.class)
 public ResponseEntity<Error>manejarCategoriaException(CategoriaException ex){
   Error error=new Error(
    HttpStatus.NOT_FOUND.value(),
    ex.getMessage(),
    System.currentTimeMillis()
   );
   return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(ProductoException.class)
 public ResponseEntity<Error>manejarProductoException(ProductoException ex){
    Error error=new Error(
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage(),
        System.currentTimeMillis()
    );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }
}
