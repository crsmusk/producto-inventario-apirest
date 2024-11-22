package com.apirest.apirest.Servicio.Interface;

import com.apirest.apirest.Model.DTOs.permisoDTO;

import java.util.List;

public interface IPermiso {
    public List<permisoDTO> findAll();
    public permisoDTO findById(Long id);
    public permisoDTO findByNombrePermiso(String nombre);
    public permisoDTO update(Long id,permisoDTO permisoDTO);
    public void save(permisoDTO permisoDTO);
    public void delete(Long id);
}
