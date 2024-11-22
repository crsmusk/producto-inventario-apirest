package com.apirest.apirest.Servicio.Impl;


import com.apirest.apirest.Exception.noHayContenidoException;
import com.apirest.apirest.Exception.permisoException;
import com.apirest.apirest.Exception.rolException;
import com.apirest.apirest.Model.DTOs.rolDTO;
import com.apirest.apirest.Model.Entidades.permiso;
import com.apirest.apirest.Model.Entidades.rol;
import com.apirest.apirest.Repositorio.PermisoRepository;
import com.apirest.apirest.Repositorio.RolRepository;
import com.apirest.apirest.Servicio.Interface.IRol;
import com.apirest.apirest.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rolService implements IRol {

    @Autowired
    RolRepository rolRepos;
    @Autowired
    RolMapper mapper;
    @Autowired
    PermisoRepository permisoRepo;


    @Override
    public List<rolDTO> findAll() {
        List<rol>lista=rolRepos.findAll();
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.rolesToRolesDto(lista);
    }

    @Override
    public rolDTO findById(Long id) {
        rol rol=rolRepos.findById(id).orElseThrow(()->new rolException());
        return mapper.rolToRolDto(rol);
    }

    @Override
    public rolDTO findByNombrePermiso(String nombre) {
        rol rol=rolRepos.findByNombreRolIgnoreCase(nombre).orElseThrow(()->new rolException());
        return mapper.rolToRolDto(rol);
    }

    @Override
    public rolDTO update(Long id, rolDTO rolDTO) {
        rol rol=rolRepos.findById(id).orElseThrow(()->new rolException());
        rol.setNombreRol(rolDTO.getNomreRol());
        List<permiso>lista=rolDTO.getPermisos().stream().map(permiso->permisoRepo.findByNombrePermisoIgnoreCase(permiso).orElseThrow(()->new permisoException())).toList();
        rol.setPermisos(lista);
        rolRepos.save(rol);
        return mapper.rolToRolDto(rol);
    }

    @Override
    public void save(rolDTO rolDTO) {
        rol rol=new rol();
        rol.setNombreRol(rolDTO.getNomreRol());
        List<permiso>lista=rolDTO.getPermisos().stream().map(permiso->permisoRepo.findByNombrePermisoIgnoreCase(permiso).orElseThrow(()->new permisoException())).toList();
        rol.setPermisos(lista);
        rolRepos.save(rol);
    }

    @Override
    public rolDTO changePermisos(Long id, List<String> permisos) {
        rol rol=rolRepos.findById(id).orElseThrow(()->new rolException());
        List<permiso>lista=permisos.stream().map(permiso->permisoRepo.findByNombrePermisoIgnoreCase(permiso).orElseThrow(()->new permisoException())).toList();
        rol.setPermisos(lista);
        return mapper.rolToRolDto(rol);
    }

    @Override
    public void delete(Long id) {
        if (rolRepos.existsById(id)){
            rolRepos.deleteById(id);
        }else{
            throw new rolException();
        }
    }
}
