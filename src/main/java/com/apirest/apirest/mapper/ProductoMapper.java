package com.apirest.apirest.mapper;




import java.util.List;

import org.springframework.stereotype.Component;

import com.apirest.apirest.Model.DTOs.productoDTO;
import com.apirest.apirest.Model.Entidades.producto;

@Component
public class ProductoMapper {
   public productoDTO toProductoDto(producto producto){
    return productoDTO.builder()
    .nombre(producto.getNombre())
    .precio(producto.getPrecio())
    .cantidad(producto.getCantidad())
    .categoria(producto.getCategoria())
    .build();
   }

   public List<productoDTO>toproductosDto(List<producto>productos){
    return productos.stream().map(this::toProductoDto).toList();
   }

   public producto toProducto(productoDTO productoDTO){
    producto producto=new producto();
    producto.setNombre(productoDTO.getNombre());
    producto.setCantidad(productoDTO.getCantidad());
    producto.setPrecio(productoDTO.getPrecio());
    return producto;
    
   }
}
