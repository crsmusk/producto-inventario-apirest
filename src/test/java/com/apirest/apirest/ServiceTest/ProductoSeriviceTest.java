package com.apirest.apirest.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apirest.apirest.Exception.ProductoException;
import com.apirest.apirest.Model.DTOs.productoDTO;
import com.apirest.apirest.Repositorio.ProductoRepository;
import com.apirest.apirest.Servicio.Impl.ProductoService;

/*@SpringBootTest
public class ProductoSeriviceTest {
   private productoDTO productoDTOEsperado;
   private Long id;

   @Autowired
   ProductoService productoService;
   @Autowired
   ProductoRepository productoRepo;
   @BeforeEach
   public void setUp(){
     productoDTOEsperado=new productoDTO();
     productoDTOEsperado.setNombre("jabon");
     productoDTOEsperado.setCantidad(78);
     productoDTOEsperado.setPrecio(1.99);
     productoService.save(productoDTOEsperado);
   }

   @Test
   public void producto_find_by_id(){
    id=productoRepo.findByNombreIgnoreCase(productoDTOEsperado.getNombre()).get(0).getId();
    Optional<productoDTO> productoDTOptenido=productoService.findById(id);

    assertTrue(productoDTOptenido.isPresent());
    assertEquals(productoDTOEsperado, productoDTOptenido.get());
   }

   @Test
   public void producto_find_by_name(){
    Optional<List<productoDTO>>productoDto=productoService.findByNombre("jabon");
    productoDTO productoDtoOptenido=productoDto.get().getFirst();

    assertTrue(productoDto.isPresent());
    assertEquals(productoDTOEsperado, productoDtoOptenido);

   }

   @Test
   public void producto_update(){
    id=productoRepo.findByNombreIgnoreCase(productoDTOEsperado.getNombre()).get(0).getId();
    productoDTOEsperado.setNombre("papas");
    productoService.update(id, productoDTOEsperado);

    Optional<productoDTO>productoDtoOptenido=productoService.findById(id);
    
    assertTrue(productoDtoOptenido.isPresent());
    assertEquals(productoDTOEsperado, productoDtoOptenido.get());

   }

   @Test
   public void producto_low_Stock(){
    List<productoDTO>productoDto=productoService.lowStock(100);
    productoDTO productoDtoObtenido=productoDto.get(0);

    assertEquals(productoDTOEsperado, productoDtoObtenido);

   }

   @Test
   public void producto_find_By_Id_Exception(){
    assertThrows(ProductoException.class, ()->{
        productoService.findById(98L);
    });
   }

   @AfterEach
   public void delete_class(){
     id=productoRepo.findByNombreIgnoreCase(productoDTOEsperado.getNombre()).get(0).getId();
     productoService.delete(id);
   }



   
}*/
