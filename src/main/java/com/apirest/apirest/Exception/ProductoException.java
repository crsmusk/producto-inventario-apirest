package com.apirest.apirest.Exception;

public class ProductoException extends RuntimeException{
   
    public ProductoException(){
        super("producto no encontrado");
    }
}
