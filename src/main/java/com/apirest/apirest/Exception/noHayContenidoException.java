package com.apirest.apirest.Exception;

public class noHayContenidoException extends RuntimeException{
    public noHayContenidoException(){
        super("no hay contenido");
    }
}
