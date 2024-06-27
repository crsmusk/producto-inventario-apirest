package com.apirest.apirest.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.apirest.Entidades.productos;

public interface ProductoRepositorio extends JpaRepository<productos,Long> {
    Optional<productos>findByNombre(String nombre);
}
