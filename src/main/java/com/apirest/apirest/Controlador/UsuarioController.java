package com.apirest.apirest.Controlador;

import com.apirest.apirest.Model.DTOs.rolDTO;
import com.apirest.apirest.Model.DTOs.usuarioDTO;
import com.apirest.apirest.Servicio.Impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<usuarioDTO>>getAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-user-name/{username}")
    public ResponseEntity<usuarioDTO>getByUserName(@PathVariable String username){
        return new ResponseEntity<>(usuarioService.findByUserName(username),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-Id/{id}")
    public ResponseEntity<usuarioDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody usuarioDTO usuarioDTO){
        usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/cambiar-roles/{id}")
    public ResponseEntity<usuarioDTO>changeRole(@PathVariable Long id, @RequestBody List<String> roles){
        return new ResponseEntity<>(usuarioService.changeRol(id,roles),HttpStatus.OK);
    }
    @PatchMapping("/cambiar-nombre/{id}")
    public ResponseEntity<usuarioDTO>changeUserName(@PathVariable Long id,@RequestBody String nombre){
        return new ResponseEntity<>(usuarioService.changeUserName(id,nombre),HttpStatus.OK);
    }

    @PatchMapping("/cambiar-contraseña/{id}")
    public ResponseEntity<usuarioDTO>changePassword(@PathVariable Long id,@RequestBody String password){
        return new ResponseEntity<>(usuarioService.changePassword(id,password),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuarioDTO>update(@PathVariable Long id,@RequestBody usuarioDTO usuarioDTO){
        return new ResponseEntity<>(usuarioService.update(id,usuarioDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
