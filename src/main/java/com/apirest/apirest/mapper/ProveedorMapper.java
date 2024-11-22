package com.apirest.apirest.mapper;

import com.apirest.apirest.Model.DTOs.proveedorDTO;
import com.apirest.apirest.Model.Entidades.proveedor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorMapper {
    public proveedorDTO proveedorToProveedorDto(proveedor proveedor){
        proveedorDTO proveedorDto= proveedorDTO.builder()
                .nombreProveedor(proveedor.getNombreProveedor())
                .nombreMarca((proveedor.getNombreMarca()))
                .email(proveedor.getEmail())
                .numeroTelefono(proveedor.getNumeroTelefono())
                .id(proveedor.getId())
                .build();
        return proveedorDto;
    }

    public List<proveedorDTO>proveedoresTOproveedoresDTO(List<proveedor>proveedores){
        return proveedores.stream().map(this::proveedorToProveedorDto).toList();
    }
}
