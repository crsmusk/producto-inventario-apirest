package com.apirest.apirest.Exception;

public class CategoriaException extends RuntimeException {
   public CategoriaException(){
    super("categoria no encontrada");
   }
}
