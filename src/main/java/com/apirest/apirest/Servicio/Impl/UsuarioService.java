package com.apirest.apirest.Servicio.Impl;

import com.apirest.apirest.Exception.noHayContenidoException;
import com.apirest.apirest.Exception.rolException;
import com.apirest.apirest.Exception.usuarioException;
import com.apirest.apirest.Model.DTOs.usuarioDTO;
import com.apirest.apirest.Model.Entidades.rol;
import com.apirest.apirest.Model.Entidades.usuario;
import com.apirest.apirest.Repositorio.RolRepository;
import com.apirest.apirest.Repositorio.UsuarioRepository;
import com.apirest.apirest.Servicio.Interface.IUsuario;
import com.apirest.apirest.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    UsuarioMapper mapper;
    @Autowired
    RolRepository rolRepo;

    @Override
    public List<usuarioDTO> findAll() {
        List<usuario>lista=usuarioRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.usuariosToUsuariosDto(lista);
    }

    @Override
    public usuarioDTO findById(Long id) {
        usuario usuario=usuarioRepo.findById(id).orElseThrow(()->new usuarioException());
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public usuarioDTO findByUserName(String username) {
        usuario usuario=usuarioRepo.findByUserNameIgnoreCase(username).orElseThrow(()->new usuarioException());
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public void save(usuarioDTO usuarioDTO) {
       usuario usuario=new usuario();
       usuario.setPassword(usuarioDTO.getPassword());
       usuario.setUserName(usuarioDTO.getUserName());
       List<rol>lista=usuarioDTO.getRoles().stream().map(rol->rolRepo.findByNombreRolIgnoreCase(rol).orElseThrow(()->new rolException())).toList();
       usuario.setRoles(lista);
       usuarioRepo.save(usuario);
    }

    @Override
    public usuarioDTO update(Long id, usuarioDTO usuarioDTO) {
        usuario usuario=usuarioRepo.findById(id).orElseThrow(()->new usuarioException());
        usuario.setUserName(usuarioDTO.getUserName());
        usuario.setPassword(usuarioDTO.getPassword());
        List<rol>lista=usuarioDTO.getRoles().stream().map(rol->rolRepo.findByNombreRolIgnoreCase(rol).orElseThrow(()->new rolException())).toList();
        usuario.setRoles(lista);
        usuarioRepo.save(usuario);
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public usuarioDTO changeRol(Long id, List<String> roles) {
        usuario usuario=usuarioRepo.findById(id).orElseThrow(()->new usuarioException());
        List<rol>lista=roles.stream().map(rol->rolRepo.findByNombreRolIgnoreCase(rol).orElseThrow(()->new rolException())).toList();
        usuario.setRoles(lista);
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public usuarioDTO changeUserName(Long id, String username) {
        usuario usuario=usuarioRepo.findById(id).orElseThrow(()->new usuarioException());
        usuario.setUserName(username);
        usuarioRepo.save(usuario);
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public usuarioDTO changePassword(Long id, String password) {
        usuario usuario=usuarioRepo.findById(id).orElseThrow(()->new usuarioException());
        usuario.setPassword(password);
        return mapper.usuarioToUsuarioDto(usuario);
    }

    @Override
    public void delete(Long id) {
      if (usuarioRepo.existsById(id)){
          usuarioRepo.deleteById(id);
      }else{
          throw new usuarioException();
      }
    }
}
