package com.apirest.apirest.Model.DTOs;


import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class proveedorDTO {
    private Long id;
    private String nombreMarca;
    private String nombreProveedor;
    private String numeroTelefono;
    private String email;
}
