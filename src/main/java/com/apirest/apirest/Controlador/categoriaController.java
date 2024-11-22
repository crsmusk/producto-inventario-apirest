package com.apirest.apirest.Controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Model.DTOs.categoriaDTO;
import com.apirest.apirest.Servicio.Impl.CategoriaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categoria")
public class categoriaController {
 
    @Autowired 
    CategoriaService categoriaService;
    
    @GetMapping
    public ResponseEntity<List<categoriaDTO>>getAll(){
     return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("buscar-por-id/{id}")
    public ResponseEntity<categoriaDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(categoriaService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre/{nombreCategoria}")
    public ResponseEntity<categoriaDTO>getByName(@PathVariable String nombreCategoria){
       return new ResponseEntity<>(categoriaService.findByName(nombreCategoria),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody categoriaDTO categoriaDTO){
        categoriaService.save(categoriaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoriaDTO> update(@PathVariable Long id,@RequestBody categoriaDTO categoriaDTO){
        return new ResponseEntity<>(categoriaService.update(id,categoriaDTO),HttpStatus.OK);
    }


    
}
