package com.apirest.apirest.Servicio.userDetails;

import com.apirest.apirest.Exception.usuarioException;
import com.apirest.apirest.Model.Entidades.rol;
import com.apirest.apirest.Model.Entidades.usuario;
import com.apirest.apirest.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class userDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario usuario=usuarioRepo.findByUserNameIgnoreCase(username).orElseThrow(()->new usuarioException());
        List<SimpleGrantedAuthority>lista=new ArrayList<>();
        usuario.getRoles().stream().forEach(rol->lista.add(new SimpleGrantedAuthority("ROLE_".concat(rol.getNombreRol()))));
        usuario.getRoles().stream().flatMap(rol->rol.getPermisos().stream()).forEach(permiso->lista.add(new SimpleGrantedAuthority(permiso.getNombrePermiso())));

        return new User(usuario.getUserName(),usuario.getPassword(),
                usuario.getIsEnable(),usuario.getAccountNoExpired(),
                usuario.getCredentialNoExpired(),usuario.getAccountNoLoked(),lista);
    }
}
