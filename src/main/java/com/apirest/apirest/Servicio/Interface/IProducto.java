package com.apirest.apirest.Servicio.Interface;

import java.util.List;
import java.util.Optional;


import com.apirest.apirest.Model.DTOs.productoDTO;


public interface IProducto {
 
 public List<productoDTO>findAll();
 public productoDTO findById(Long id);
 public List<productoDTO>findByNombre(String name);
 public List<productoDTO>lowStock(int lessthan);
 public void save(productoDTO productoDTO);
 public void delete(Long id);
 public productoDTO update(Long id,productoDTO ProductoDTO);
 public productoDTO updateStock(Long id,int newStock);
 public productoDTO changeMarca(Long id,String marca);
}
