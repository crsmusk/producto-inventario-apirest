package com.apirest.apirest.Repositorio;

import com.apirest.apirest.Model.Entidades.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario,Long> {
    Optional<usuario>findByUserNameIgnoreCase(String nombre);
}
