package com.apirest.apirest.Repositorio;

import com.apirest.apirest.Model.Entidades.rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository <rol,Long> {
    Optional<rol>findByNombreRolIgnoreCase(String nombre);
}
