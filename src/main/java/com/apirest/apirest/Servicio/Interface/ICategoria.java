package com.apirest.apirest.Servicio.Interface;

import java.util.List;
import java.util.Optional;

import com.apirest.apirest.Model.DTOs.categoriaDTO;

public interface ICategoria {
 public List<categoriaDTO>findAll();
 public Optional<categoriaDTO>findById(Long id);
 public void save(categoriaDTO categoriaDTO);
 public Optional<categoriaDTO>findByName(String name);
 public void delete(Long id);
 public categoriaDTO update(Long id,categoriaDTO categoriaDTO);
}
