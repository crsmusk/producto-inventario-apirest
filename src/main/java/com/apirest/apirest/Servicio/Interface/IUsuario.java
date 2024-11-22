package com.apirest.apirest.Servicio.Interface;

import com.apirest.apirest.Model.DTOs.usuarioDTO;

import java.util.List;

public interface IUsuario {
    public List<usuarioDTO>findAll();
    public usuarioDTO findById(Long id);
    public usuarioDTO findByUserName(String username);
    public void save(usuarioDTO usuarioDTO);
    public usuarioDTO update(Long id,usuarioDTO usuarioDTO);
    public usuarioDTO changeRol(Long id,List<String>roles);
    public usuarioDTO changeUserName(Long id,String username);
    public usuarioDTO changePassword(Long id,String password);
    public void delete(Long id);
}
