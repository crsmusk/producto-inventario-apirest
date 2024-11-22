package com.apirest.apirest.Servicio.Impl;

import java.util.List;
import java.util.Optional;

import com.apirest.apirest.Exception.noHayContenidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Model.DTOs.categoriaDTO;
import com.apirest.apirest.Model.Entidades.categoria;
import com.apirest.apirest.Repositorio.CategoriaRepository;
import com.apirest.apirest.Servicio.Interface.ICategoria;
import com.apirest.apirest.mapper.CategoriaMapper;

@Service
public class CategoriaService implements ICategoria{

    @Autowired
    private  CategoriaMapper mapper;
    

    @Autowired
    private CategoriaRepository categoriaRepo;
    

    @Override
    @Transactional
    public List<categoriaDTO> findAll() {
        List<categoria>lista=categoriaRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.toCategoriasDto(lista);
    }

    @Override
    public categoriaDTO findById(Long id) {
        categoria category=categoriaRepo.findById(id).orElseThrow(()->new CategoriaException());
        return mapper.toCategoriaDto(category);
    }

    @Override
    public void save(categoriaDTO categoriaDTO) {
       categoria categoria=new categoria();
       categoria.setNombreCategoria(categoriaDTO.getNombre());
       categoriaRepo.save(categoria);
    }

    @Override
    public categoriaDTO findByName(String name) {
       categoria category=categoriaRepo.findByNombreCategoriaIgnoreCase(name).orElseThrow(()->new CategoriaException());
       return mapper.toCategoriaDto(category);
    }

    @Override
    public void delete(Long id) {
        if (categoriaRepo.existsById(id)){
            categoriaRepo.deleteById(id);
        }else{
            throw new CategoriaException();
        }

    }

    @Override
    public categoriaDTO update(Long id, categoriaDTO categoriaDto) {
        categoria category=categoriaRepo.findById(id).orElseThrow(()->new CategoriaException());
        category.setNombreCategoria(categoriaDto.getNombre());
        categoriaRepo.save(category);
        return mapper.toCategoriaDto(category);
    }
    

}
