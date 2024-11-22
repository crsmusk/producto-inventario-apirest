package com.apirest.apirest.mapper;

import com.apirest.apirest.Model.DTOs.permisoDTO;
import com.apirest.apirest.Model.Entidades.permiso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermisoMapper {
    public permisoDTO  permisoToPermisoDto(permiso permiso){
        permisoDTO permisoDto=permisoDTO.builder()
                .nombrePermiso(permiso.getNombrePermiso())
                .id(permiso.getId())
                .build();
        return permisoDto;
    }

    public List<permisoDTO>permisosToPermisosDto(List<permiso>permisos){
        return permisos.stream().map(this::permisoToPermisoDto).toList();
    }
}
