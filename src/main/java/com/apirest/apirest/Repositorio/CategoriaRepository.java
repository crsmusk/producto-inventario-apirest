package com.apirest.apirest.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apirest.Model.Entidades.categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<categoria,Long> {
   categoria  findByNombreCategoriaIgnoreCase(String nombreCategoria);
}
