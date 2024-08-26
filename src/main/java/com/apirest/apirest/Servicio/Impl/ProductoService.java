package com.apirest.apirest.Servicio.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import com.apirest.apirest.Exception.ProductoException;
import com.apirest.apirest.Model.DTOs.productoDTO;
import com.apirest.apirest.Model.Entidades.producto;
import com.apirest.apirest.Repositorio.ProductoRepository;
import com.apirest.apirest.Servicio.Interface.IProducto;
import com.apirest.apirest.mapper.ProductoMapper;

@Service
public class ProductoService implements IProducto {
    @Autowired
    private  ProductoMapper mapper;
    
   

    @Autowired
    private ProductoRepository productRepo;
   
    @Override
    public List<productoDTO> findAll() {
        List<productoDTO>lista=mapper.toproductosDto(productRepo.findAll());
        return lista;
    }

    @Override
    public Optional<productoDTO> findById(Long id) {
        producto product=productRepo.findById(id).orElseThrow(()->new ProductoException());
        productoDTO producto=mapper.toProductoDto(product);
        return Optional.of(producto);
    }

    @Override
    public Optional<List<productoDTO>> findByNombre(String name) {
      List<productoDTO>product=mapper.toproductosDto(productRepo.findByNombreIgnoreCase(name));
      return Optional.of(product);
    }

    @Override
    public List<productoDTO> lowStock(int lessthan) {
        List<productoDTO>product=mapper.toproductosDto(productRepo.findByCantidadLessThan(lessthan));
        return product;
    }

    @Override
    public void save(productoDTO productoDTO) {
       
       productRepo.save(mapper.toProducto(productoDTO));
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public productoDTO update(Long id, productoDTO ProductoDTO) {
        producto product=productRepo.findById(id).orElseThrow(()->new ProductoException());
        product.setNombre(ProductoDTO.getNombre());
        product.setPrecio(ProductoDTO.getPrecio());
        product.setCantidad(ProductoDTO.getCantidad());
        productRepo.save(product);
        return mapper.toProductoDto(product);
    }
    
   
    
     


}
