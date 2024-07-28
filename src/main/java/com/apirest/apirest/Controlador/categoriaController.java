package com.apirest.apirest.Controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<categoriaDTO>getAll(){
     return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<categoriaDTO>getById(@PathVariable Long id){
        if(categoriaService.findById(id).isPresent()){
            return categoriaService.findById(id);
        }else{
            throw new CategoriaException();
        }
    }

    @GetMapping("/buscarPorNombre/{nombreCategoria}")
    public Optional<categoriaDTO>getByName(@PathVariable String nombre){
        if(categoriaService.findByName(nombre).isPresent()){
            return categoriaService.findByName(nombre);
        }else{
            throw new CategoriaException();
        }
    }

    @PostMapping
    public String save(@RequestBody categoriaDTO categoriaDTO){
        categoriaService.save(categoriaDTO);
        return "se guardo con exito la categoria";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        categoriaService.delete(id);
        return "se borro con exito la categoria";
    }

    @PutMapping("/{id}")
    public categoriaDTO update(@PathVariable Long id,@RequestBody categoriaDTO categoriaDTO){
        return categoriaService.update(id, categoriaDTO);
    }


    
}
