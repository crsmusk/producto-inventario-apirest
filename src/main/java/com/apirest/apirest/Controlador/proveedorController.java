package com.apirest.apirest.Controlador;

import com.apirest.apirest.Model.DTOs.proveedorDTO;
import com.apirest.apirest.Model.Entidades.proveedor;
import com.apirest.apirest.Servicio.Impl.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class proveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<proveedorDTO>>getAll(){
        return new ResponseEntity<>(proveedorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre-proveedor/{nombre}")
    public ResponseEntity<List<proveedorDTO>>getByNombreProveedor(@PathVariable String nombre){
        return new ResponseEntity<>(proveedorService.findByNombreProveedor(nombre),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-marca/{marca}")
    public ResponseEntity<proveedorDTO>getByMarca(@PathVariable String marca){
        return new ResponseEntity<>(proveedorService.findByNombreMarca(marca),HttpStatus.OK);
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<proveedorDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(proveedorService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody proveedorDTO proveedorDTO){
        proveedorService.save(proveedorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<proveedorDTO>update(@PathVariable Long id,@RequestBody proveedorDTO proveedorDTO){
        return new ResponseEntity<>(proveedorService.update(id,proveedorDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
