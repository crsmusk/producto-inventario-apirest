package com.apirest.apirest.Servicio.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Model.DTOs.categoriaDTO;
import com.apirest.apirest.Model.Entidades.categoria;
import com.apirest.apirest.Repositorio.CategoriaRepository;
import com.apirest.apirest.Servicio.CategoriaDAO;
import com.apirest.apirest.mapper.CategoriaMapper;

@Service
public class CategoriaService implements CategoriaDAO{

    @Autowired
    private  CategoriaMapper mapper;
    

    @Autowired
    private CategoriaRepository categoriaRepo;
    
    

    @Override
    public List<categoriaDTO> findAll() {
        List<categoriaDTO>lista=mapper.toCategoriasDto(categoriaRepo.findAll());
        return lista;
    }

    @Override
    public Optional<categoriaDTO> findById(Long id) {
        categoria category=categoriaRepo.findById(id).orElseThrow(()->new CategoriaException());
        categoriaDTO categoria=mapper.toCategoriaDto(category);
        return Optional.of(categoria);
    }

    @Override
    public void save(categoriaDTO categoriaDTO) {
        categoriaRepo.save(mapper.toCategoria(categoriaDTO));
    }

    @Override
    public Optional<categoriaDTO> findByName(String name) {
       categoria category=categoriaRepo.findByNombreCategoriaIgnoreCase(name);
       categoriaDTO categoria=mapper.toCategoriaDto(category);
       return Optional.of(categoria);
       
       
    }

    @Override
    public void delete(Long id) {
      categoriaRepo.deleteById(id);
    }

    @Override
    public categoriaDTO update(Long id, categoriaDTO categoriaDTO) {
        categoria category=categoriaRepo.findById(id).orElseThrow(()->new CategoriaException());
        category.setNombreCategoria(categoriaDTO.getNombre());
        categoriaRepo.save(category);
        return mapper.toCategoriaDto(category);
    }
    

}
