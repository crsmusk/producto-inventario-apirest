package com.apirest.apirest.Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apirest.Model.Entidades.producto;
@Repository
public interface ProductoRepository extends JpaRepository<producto,Long> {
    List<producto>findByNombreIgnoreCase(String nombre);
    List<producto>findByCantidadLessThan(int menor);
}
