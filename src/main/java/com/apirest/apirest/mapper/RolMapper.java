package com.apirest.apirest.mapper;

import com.apirest.apirest.Model.DTOs.rolDTO;
import com.apirest.apirest.Model.Entidades.permiso;
import com.apirest.apirest.Model.Entidades.rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapper {
    public rolDTO rolToRolDto(rol rol){
        rolDTO rolDto=rolDTO.builder()
                .nomreRol(rol.getNombreRol())
                .permisos(rol.getPermisos().stream().map(permiso::getNombrePermiso).toList())
                .id(rol.getId())
                .build();
        return rolDto;
    }
    public List<rolDTO> rolesToRolesDto(List<rol>roles){
        return roles.stream().map(this::rolToRolDto).toList();
    }
}
