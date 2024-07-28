package com.apirest.apirest.mapper;



import java.util.List;

import org.springframework.stereotype.Component;

import com.apirest.apirest.Model.DTOs.categoriaDTO;
import com.apirest.apirest.Model.Entidades.categoria;

@Component
public class CategoriaMapper {

      public categoriaDTO toCategoriaDto(categoria categoria){
        return categoriaDTO.builder()
        .nombre(categoria.getNombreCategoria())
        .build();
      } 

      public List<categoriaDTO>toCategoriasDto(List<categoria> categorias){
        return categorias.stream().map(this::toCategoriaDto).toList();
      }

      public categoria toCategoria(categoriaDTO categoriaDTO){
        categoria categoria=new categoria();
        categoria.setNombreCategoria(categoriaDTO.getNombre());
        return categoria;
      }
}
