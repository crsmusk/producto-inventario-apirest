package com.apirest.apirest.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apirest.apirest.Exception.CategoriaException;
import com.apirest.apirest.Model.DTOs.categoriaDTO;
import com.apirest.apirest.Repositorio.CategoriaRepository;
import com.apirest.apirest.Servicio.Impl.CategoriaService;

/*@SpringBootTest
public class categoriaServiceTest {

    private categoriaDTO categoriaDTOEsperada;
    private Long id;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    CategoriaRepository categoriaRepo;

    @BeforeEach
    public void setUp(){
        categoriaDTOEsperada=new categoriaDTO();
        categoriaDTOEsperada.setNombre("limpieza");
        categoriaService.save(categoriaDTOEsperada);
    }

    @Test
    public void categoria_find_by_id(){
        id=categoriaRepo.findByNombreCategoriaIgnoreCase(categoriaDTOEsperada.getNombre()).get().getId();
        Optional<categoriaDTO> categoriaDTOObtenida=categoriaService.findById(id);

        assertTrue(categoriaDTOObtenida.isPresent());
        assertEquals(categoriaDTOEsperada, categoriaDTOObtenida.get());
    }

    @Test
    public void categoria_find_by_name(){
        Optional<categoriaDTO>categoriaDtoOptenida=categoriaService.findByName("limpieza");

        assertTrue(categoriaDtoOptenida.isPresent());
        assertEquals(categoriaDTOEsperada, categoriaDtoOptenida.get());
    }

    @Test
    public void categoria_update(){
         id=categoriaRepo.findByNombreCategoriaIgnoreCase(categoriaDTOEsperada.getNombre()).get().getId();
        categoriaDTOEsperada.setNombre("bebidas");
        categoriaService.update(id, categoriaDTOEsperada);

        Optional<categoriaDTO>categoriaDtoOptenida=categoriaService.findById(id);

        assertTrue(categoriaDtoOptenida.isPresent());
        assertEquals(categoriaDTOEsperada, categoriaDtoOptenida.get());
        
    }

    @Test
    public void categoria_find_By_id_exception(){
        assertThrows(CategoriaException.class, ()->{
            categoriaService.findById(98L);
        });
    }

    @AfterEach
    public void delete_categoriaDto_Class(){
         id=categoriaRepo.findByNombreCategoriaIgnoreCase(categoriaDTOEsperada.getNombre()).get().getId();
         categoriaService.delete(id);
    }

}
*/