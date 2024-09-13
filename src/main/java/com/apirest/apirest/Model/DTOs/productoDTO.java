package com.apirest.apirest.Model.DTOs;

import com.apirest.apirest.Model.Entidades.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class productoDTO {
    Long id;
    private String nombre;
    private double precio;
    private int  cantidad;
    private categoria categoria;
}
