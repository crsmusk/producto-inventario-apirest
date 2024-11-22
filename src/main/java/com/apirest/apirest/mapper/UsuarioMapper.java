package com.apirest.apirest.mapper;

import com.apirest.apirest.Model.DTOs.usuarioDTO;
import com.apirest.apirest.Model.Entidades.rol;
import com.apirest.apirest.Model.Entidades.usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {
    public usuarioDTO usuarioToUsuarioDto(usuario usuario){
        usuarioDTO usuarioDto=usuarioDTO.builder()
                .userName(usuario.getUserName())
                .id(usuario.getId())
                .password(usuario.getPassword())
                .roles(usuario.getRoles().stream().map(rol::getNombreRol).toList())
                .build();
        return usuarioDto;
    }

    public List<usuarioDTO>usuariosToUsuariosDto(List<usuario>usuarios){
        return usuarios.stream().map(this::usuarioToUsuarioDto).toList();
    }
}
