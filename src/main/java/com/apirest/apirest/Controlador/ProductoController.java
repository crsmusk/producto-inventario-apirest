package com.apirest.apirest.Controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Exception.ProductoException;
import com.apirest.apirest.Model.DTOs.productoDTO;
import com.apirest.apirest.Servicio.Impl.ProductoService;
@RequestMapping("/productos")
@RestController
public class ProductoController {
  @Autowired
  private ProductoService productService;

  @GetMapping
  public List<productoDTO>getAll(){
    return productService.findAll();
  }

  @GetMapping ("/{id}")
  public Optional<productoDTO> getById (@PathVariable Long id){
    if (productService.findById(id).isPresent()) {
        return productService.findById(id);
    }else{
      throw new ProductoException();
    }
    
  }

  @GetMapping("/buscarPorNombre/{nombre}")
  public Optional<List<productoDTO>>getAllByNombre(@PathVariable String nombre){
    if (productService.findByNombre(nombre).isPresent()) {
      return productService.findByNombre(nombre);
    }else{
      throw new ProductoException();
    }
    
  }

  @GetMapping("/Stock/{referencia}")
  public List<productoDTO>getLowStock(@PathVariable int referencia){
    return productService.lowStock(referencia);
  }

  @PostMapping
  public String save(@RequestBody productoDTO productoDTO){
    productService.save(productoDTO);
    return "se ha guardado con exito";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id){
    productService.delete(id);
    return "se ha eliminado con exito";
  }

  @PutMapping("/{id}")
  public productoDTO update(@PathVariable Long id,@RequestBody productoDTO productoDTO){
    return productService.update(id, productoDTO);
  }


  

}
