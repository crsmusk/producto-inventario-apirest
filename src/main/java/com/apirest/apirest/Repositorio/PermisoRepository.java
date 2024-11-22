package com.apirest.apirest.Repositorio;

import com.apirest.apirest.Model.Entidades.permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PermisoRepository extends JpaRepository<permiso,Long> {
    Optional<permiso>findByNombrePermisoIgnoreCase(String nombre);
}
