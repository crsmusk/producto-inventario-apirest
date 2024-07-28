package com.apirest.apirest.Servicio;

import java.util.List;
import java.util.Optional;


import com.apirest.apirest.Model.DTOs.productoDTO;


public interface ProductoDAO {
 
 public List<productoDTO>findAll();
 public Optional<productoDTO>findById(Long id);
 public Optional<List<productoDTO>>findByNombre(String name);
 public List<productoDTO>lowStock(int lessthan);
 public void save(productoDTO productoDTO);
 public void delete(Long id);
 public productoDTO update(Long id,productoDTO ProductoDTO);
}
