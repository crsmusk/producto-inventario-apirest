package com.apirest.apirest.Servicio.Interface;

import com.apirest.apirest.Model.DTOs.proveedorDTO;

import java.util.List;

public interface IProveedor {
    public List<proveedorDTO>findAll();
    public proveedorDTO findById(Long id);
    public List<proveedorDTO> findByNombreProveedor(String nombre);
    public proveedorDTO findByNombreMarca(String marca);
    public void save(proveedorDTO proveedorDTO);
    public void delete(Long id);
    public proveedorDTO update(Long id,proveedorDTO proveedorDTO);

}
