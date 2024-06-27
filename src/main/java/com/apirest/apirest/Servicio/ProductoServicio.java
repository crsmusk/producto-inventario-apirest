package com.apirest.apirest.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

import com.apirest.apirest.Entidades.productos;
import com.apirest.apirest.Repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productRepo;
    
    public List<productos> traerProductos() {
        return productRepo.findAll();
    }
    
    public productos traerProducto(Long id) {
        return productRepo.findById(id).orElseThrow(null);
    }
    //busca un producto por nombre
    public productos buscarProducto(String nombre) {
        return productRepo.findByNombre(nombre).orElseThrow(null);
    }
    
    public productos crearProducto(productos productos) {
        return productRepo.save(productos);
    }

    public productos actualizarProducto(Long id, productos detalles) {
        productos productos = productRepo.findById(id).orElseThrow(null);
        productos.setNombre(detalles.getNombre());
        productos.setPrecio(detalles.getPrecio());
        productos.setCantidad(detalles.getCantidad());
        return productRepo.save(productos);
    }

    public void borrarProducto(Long id) {
        productos producto = productRepo.findById(id).orElseThrow(null);
        productRepo.delete(producto);
    }
    //  trae la cantidad de stock de un producto por su id 
    public int cantidadDeProductos(Long id){
        productos producto = productRepo.findById(id).orElseThrow(null);
        
        return producto.getCantidad();
    }
    // trae la cantidad de stock de un producto por su nombre
    public int cantidadDeProductos(String nombre){
        productos producto = productRepo.findByNombre(nombre).orElseThrow(null);
        return producto.getCantidad();
    }
    // determina si hay bajo stock de un producto 
    public List<productos> bajoInventario(){
        List<Long> ids = new ArrayList<>();
        List<productos> lista=productRepo.findAll();
        for(productos producto:lista){
            if(producto.getCantidad()<=10){
             ids.add(producto.getId());
            }
           
        }
        return productRepo.findAllById(ids);
    }
    
     


}
