package com.apirest.apirest.Controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirest.apirest.Exception.ProductoException;
import com.apirest.apirest.Model.DTOs.productoDTO;
import com.apirest.apirest.Servicio.Impl.ProductoService;
@RequestMapping("/productos")
@RestController
public class ProductoController {
  @Autowired
  private ProductoService productService;

  @GetMapping
  public ResponseEntity<List<productoDTO>>getAll(){
    return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
  }

  @GetMapping ("/buscar-por-id/{id}")
  public ResponseEntity<productoDTO> getById (@PathVariable Long id){
   return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    
  }

  @GetMapping("/buscar-por-nombre/{nombre}")
  public ResponseEntity<List<productoDTO>>getAllByNombre(@PathVariable String nombre){
    return new ResponseEntity<>(productService.findByNombre(nombre),HttpStatus.OK);
    
  }

  @GetMapping("/Stock/{referencia}")
  public ResponseEntity<List<productoDTO>>getLowStock(@PathVariable int referencia){
    return new ResponseEntity<>(productService.lowStock(referencia),HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody productoDTO productoDTO){
    productService.save(productoDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    productService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<productoDTO>update(@PathVariable Long id,@RequestBody productoDTO productoDTO){
    return new ResponseEntity<>(productService.update(id,productoDTO),HttpStatus.OK);
  }

  @PatchMapping("/actualizar-stock/{id}/{cantidad}")
  public ResponseEntity<productoDTO>updateStock(@PathVariable Long id,@PathVariable int cantidad){
    return new ResponseEntity<>(productService.updateStock(id,cantidad),HttpStatus.OK);
  }

  @PatchMapping("/cambiar-marca/{id}/{marca}")
  public ResponseEntity<productoDTO>changeMarca(@PathVariable Long id,@PathVariable String marca){
    return new ResponseEntity<>(productService.changeMarca(id,marca),HttpStatus.OK);
  }

  

}
