package com.apirest.apirest.Controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Entidades.productos;
import com.apirest.apirest.Servicio.ProductoServicio;
@RequestMapping("/productos")
@RestController
public class ProductoControllador {
  @Autowired
  private ProductoServicio productService;
  
  @GetMapping
  public List<productos>getAllProuctos(){
    return productService.traerProductos();
  }

  @GetMapping("/{id}")
  public productos getProducto(@PathVariable Long id){
    return productService.traerProducto(id);
  }

  @GetMapping("/buscar/{nombre}")
  public productos searchProductos(@PathVariable String nombre){
    return productService.buscarProducto(nombre);
  }

  @PostMapping
  public productos createProducto(@RequestBody productos producto){
    return productService.crearProducto(producto);
  }

  @PutMapping("/{id}")
  public productos updateProductos(@PathVariable Long id,@RequestBody productos producto){
    return productService.actualizarProducto(id, producto);
  }

  @DeleteMapping("/{id}")
  public void deleteProducto(@PathVariable Long id){
    productService.borrarProducto(id);
  }

  @GetMapping("/stock/{id}")
  public int stockOfProduct(@PathVariable Long id){
    return productService.cantidadDeProductos(id);
  }

  @GetMapping("/stockByName/{nombre}")
  public int stockOfProduct(@PathVariable String nombre){
    return productService.cantidadDeProductos(nombre);
  }

  @GetMapping("/alertaDebajoInventaio/")
  public List<productos> lowProductos(){
    return productService.bajoInventario();
  }
}
