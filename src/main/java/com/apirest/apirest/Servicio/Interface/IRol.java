package com.apirest.apirest.Servicio.Interface;

import com.apirest.apirest.Model.DTOs.rolDTO;

import java.util.List;

public interface IRol {
    public List<rolDTO>findAll();
    public rolDTO findById(Long id);
    public rolDTO findByNombrePermiso(String nombre);
    public rolDTO update(Long id,rolDTO rolDTO);
    public void save(rolDTO rolDTO);
    public rolDTO changePermisos(Long id,List<String>permisos);
    public void delete(Long id);
}
