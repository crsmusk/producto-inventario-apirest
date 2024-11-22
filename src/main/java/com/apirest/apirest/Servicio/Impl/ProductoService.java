package com.apirest.apirest.Servicio.Impl;

import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Exception.noHayContenidoException;
import com.apirest.apirest.Exception.proveedorException;
import com.apirest.apirest.Model.Entidades.categoria;
import com.apirest.apirest.Model.Entidades.proveedor;
import com.apirest.apirest.Repositorio.CategoriaRepository;
import com.apirest.apirest.Repositorio.ProveedorRepository;
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
    private CategoriaRepository  categoriaRepo;
    @Autowired
    private ProveedorRepository proveedorRepo;
    @Autowired
    private ProductoRepository productRepo;
   
    @Override
    public List<productoDTO> findAll() {
        List<producto>lista=productRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.toproductosDto(lista);
    }

    @Override
    public productoDTO findById(Long id) {
        producto product=productRepo.findById(id).orElseThrow(()->new ProductoException());
        return mapper.toProductoDto(product);
    }

    @Override
    public List<productoDTO> findByNombre(String name) {
      List<producto>product=productRepo.findByNombreIgnoreCase(name);
      if (product.isEmpty()){
          throw new noHayContenidoException();
      }
      return mapper.toproductosDto(product);
    }

    @Override
    public List<productoDTO> lowStock(int lessthan) {
        List<producto>lista=productRepo.findByCantidadLessThan(lessthan);
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.toproductosDto(lista);
    }

    @Override
    public void save(productoDTO productoDTO) {
        producto producto=new producto();
        producto.setCantidad(productoDTO.getCantidad());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setNombre(productoDTO.getNombre());
        categoria categoria=categoriaRepo.findByNombreCategoriaIgnoreCase(productoDTO.getCategoria()).orElseThrow(()->new CategoriaException());
        producto.setCategoria(categoria);
        proveedor proveedor=proveedorRepo.findByNombreMarcaIgnoreCase(productoDTO.getMarca()).orElseThrow(()->new proveedorException());
        producto.setProveedor(proveedor);
        productRepo.save(producto);
    }

    @Override
    public void delete(Long id) {
        if (productRepo.existsById(id)){
            productRepo.deleteById(id);
        }else{
            throw new ProductoException();
        }

    }

    @Override
    public productoDTO update(Long id, productoDTO ProductoDTO) {
        producto product=productRepo.findById(id).orElseThrow(()->new ProductoException());
        product.setNombre(ProductoDTO.getNombre());
        product.setPrecio(ProductoDTO.getPrecio());
        product.setCantidad(ProductoDTO.getCantidad());
        categoria categoria=categoriaRepo.findByNombreCategoriaIgnoreCase(ProductoDTO.getCategoria()).orElseThrow(()->new CategoriaException());
        product.setCategoria(categoria);
        proveedor proveedor=proveedorRepo.findByNombreMarcaIgnoreCase(ProductoDTO.getMarca()).orElseThrow(()->new proveedorException());
        product.setProveedor(proveedor);
        productRepo.save(product);
        return mapper.toProductoDto(product);
    }

    @Override
    public productoDTO updateStock(Long id, int newStock) {
        producto producto=productRepo.findById(id).orElseThrow(()->new ProductoException());
        producto.setCantidad(newStock);
        productRepo.save(producto);
        return mapper.toProductoDto(producto);
    }

    @Override
    public productoDTO changeMarca(Long id, String marca) {
        producto producto=productRepo.findById(id).orElseThrow(()->new ProductoException());
        proveedor proveedor=proveedorRepo.findByNombreMarcaIgnoreCase(marca).orElseThrow(()->new proveedorException());
        producto.setProveedor(proveedor);
        productRepo.save(producto);
        return mapper.toProductoDto(producto);
    }


}
