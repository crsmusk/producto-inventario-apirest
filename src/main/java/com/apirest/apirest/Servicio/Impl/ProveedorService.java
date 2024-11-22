package com.apirest.apirest.Servicio.Impl;

import com.apirest.apirest.Exception.noHayContenidoException;
import com.apirest.apirest.Exception.proveedorException;
import com.apirest.apirest.Model.DTOs.proveedorDTO;
import com.apirest.apirest.Model.Entidades.proveedor;
import com.apirest.apirest.Repositorio.ProveedorRepository;
import com.apirest.apirest.Servicio.Interface.IProveedor;
import com.apirest.apirest.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProveedorService implements IProveedor {

    @Autowired
    ProveedorMapper mapper;
    @Autowired
    ProveedorRepository proveedorRepo;

    @Override
    public List<proveedorDTO> findAll() {
        List<proveedor>lista=proveedorRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.proveedoresTOproveedoresDTO(lista);
    }

    @Override
    public proveedorDTO findById(Long id) {
        proveedor proveedor=proveedorRepo.findById(id).orElseThrow(()->new proveedorException());
        return mapper.proveedorToProveedorDto(proveedor);
    }

    @Override
    public List<proveedorDTO> findByNombreProveedor(String nombre) {
        List<proveedor> proveedor=proveedorRepo.findAllByNombreProveedorIgnoreCase(nombre);
        if (proveedor.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.proveedoresTOproveedoresDTO(proveedor);
    }

    @Override
    public proveedorDTO findByNombreMarca(String marca) {
        proveedor proveedor=proveedorRepo.findByNombreMarcaIgnoreCase(marca).orElseThrow(()->new proveedorException());
        return mapper.proveedorToProveedorDto(proveedor);
    }

    @Override
    public void save(proveedorDTO proveedorDTO) {
      proveedor proveedor=new proveedor();
      proveedor.setNombreProveedor(proveedorDTO.getNombreProveedor());
      proveedor.setEmail(proveedorDTO.getEmail());
      proveedor.setNombreMarca(proveedorDTO.getNombreMarca());
      proveedor.setNumeroTelefono(proveedorDTO.getNumeroTelefono());
      proveedorRepo.save(proveedor);
    }

    @Override
    public void delete(Long id) {
         if (proveedorRepo.existsById(id)){
             proveedorRepo.deleteById(id);
         }else{
             throw new proveedorException();
         }
    }

    @Override
    public proveedorDTO update(Long id, proveedorDTO proveedorDTO) {
        proveedor proveedor=proveedorRepo.findById(id).orElseThrow(()->new proveedorException());
        proveedor.setNombreProveedor(proveedorDTO.getNombreProveedor());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setNumeroTelefono(proveedorDTO.getNumeroTelefono());
        proveedor.setNombreMarca(proveedorDTO.getNombreMarca());
        proveedorRepo.save(proveedor);
        return mapper.proveedorToProveedorDto(proveedor);
    }
}
