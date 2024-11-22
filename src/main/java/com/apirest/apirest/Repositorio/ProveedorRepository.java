package com.apirest.apirest.Repositorio;

import com.apirest.apirest.Model.Entidades.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<proveedor,Long> {
    List<proveedor> findAllByNombreProveedorIgnoreCase(String nombre);
    Optional<proveedor>findByNombreMarcaIgnoreCase(String marca);
}
