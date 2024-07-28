package com.apirest.apirest.Model.DTOs;

import com.apirest.apirest.Model.Entidades.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class productoDTO {
    private String nombre;
    private double precio;
    private int  cantidad;
    private categoria categoria;
}
