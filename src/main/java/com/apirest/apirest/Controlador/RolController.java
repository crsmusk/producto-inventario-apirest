package com.apirest.apirest.Controlador;

import com.apirest.apirest.Model.DTOs.rolDTO;
import com.apirest.apirest.Servicio.Impl.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    rolService rolService;

    @GetMapping
    public ResponseEntity<List<rolDTO>>getAll(){
        return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<rolDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(rolService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<rolDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(rolService.findByNombrePermiso(nombre),HttpStatus.OK);
    }

    @PatchMapping("/cambiar-permisos/{id}")
    public ResponseEntity<rolDTO>changePermisos(@PathVariable Long id,@RequestBody List<String>permisos){
        return new ResponseEntity<>(rolService.changePermisos(id,permisos),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody rolDTO rolDTO){
        rolService.save(rolDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<rolDTO>update(@PathVariable Long id,@RequestBody rolDTO rolDTO){
        return new ResponseEntity<>(rolService.update(id,rolDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
