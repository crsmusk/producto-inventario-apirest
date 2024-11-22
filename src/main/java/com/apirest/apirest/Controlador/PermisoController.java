package com.apirest.apirest.Controlador;

import com.apirest.apirest.Model.DTOs.permisoDTO;
import com.apirest.apirest.Servicio.Impl.permisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permiso")
public class PermisoController {


    @Autowired
    permisoService permisoService;

    @GetMapping
    public ResponseEntity<List<permisoDTO>>getAll(){
        return new ResponseEntity<>(permisoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<permisoDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(permisoService.findByNombrePermiso(nombre),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<permisoDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(permisoService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody permisoDTO permisoDTO){
        permisoService.save(permisoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<permisoDTO>update(@PathVariable Long id,@RequestBody permisoDTO permisoDTO){
        return new ResponseEntity<>(permisoService.update(id,permisoDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        permisoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
