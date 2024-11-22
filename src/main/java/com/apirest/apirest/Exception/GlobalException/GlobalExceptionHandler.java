package com.apirest.apirest.Exception.GlobalException;



import com.apirest.apirest.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.apirest.apirest.Exception.ExceptionClass.Error;

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

 @ExceptionHandler(noHayContenidoException.class)
    public ResponseEntity<Error>manejarNoHayContenidoException(noHayContenidoException ex){
     Error error=new Error(
             HttpStatus.NO_CONTENT.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
 }

 @ExceptionHandler(proveedorException.class)
    public ResponseEntity<Error>manejarProveedorException(proveedorException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(usuarioException.class)
    public ResponseEntity<Error>manejarusuarioException(usuarioException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(rolException.class)
    public ResponseEntity<Error>manejarRolException(rolException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(permisoException.class)
    public ResponseEntity<Error>manejarPermisoException(permisoException ex){
     Error error=new Error(
             HttpStatus.NOT_FOUND.value(),
             ex.getMessage(),
             System.currentTimeMillis()
     );
     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }

}
