package com.apirest.apirest.Servicio.Impl;

import com.apirest.apirest.Exception.permisoException;
import com.apirest.apirest.Model.DTOs.permisoDTO;
import com.apirest.apirest.Model.Entidades.permiso;
import com.apirest.apirest.Repositorio.PermisoRepository;
import com.apirest.apirest.Servicio.Interface.IPermiso;
import com.apirest.apirest.mapper.PermisoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permisoService implements IPermiso {
    @Autowired
    PermisoRepository permisoRepo;
    @Autowired
    PermisoMapper mapper;

    @Override
    public List<permisoDTO> findAll() {
        List<permiso>lista=permisoRepo.findAll();
        if (lista.isEmpty()){
            throw new permisoException();
        }
        return mapper.permisosToPermisosDto(lista);
    }

    @Override
    public permisoDTO findById(Long id) {
        permiso permiso=permisoRepo.findById(id).orElseThrow(()->new permisoException());
        return mapper.permisoToPermisoDto(permiso);
    }

    @Override
    public permisoDTO findByNombrePermiso(String nombre) {
        permiso permiso=permisoRepo.findByNombrePermisoIgnoreCase(nombre).orElseThrow(()->new permisoException());
        return mapper.permisoToPermisoDto(permiso);
    }

    @Override
    public permisoDTO update(Long id, permisoDTO permisoDTO) {
        permiso permiso=permisoRepo.findById(id).orElseThrow(()->new permisoException());
        permiso.setNombrePermiso(permisoDTO.getNombrePermiso());
        return mapper.permisoToPermisoDto(permiso);
    }

    @Override
    public void save(permisoDTO permisoDTO) {
       permiso permiso=new permiso();
       permiso.setNombrePermiso(permisoDTO.getNombrePermiso());
       permisoRepo.save(permiso);
    }

    @Override
    public void delete(Long id) {
     if (permisoRepo.existsById(id)){
         permisoRepo.deleteById(id);
     }else{
         throw new permisoException();
     }
    }
}
