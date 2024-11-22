package com.apirest.apirest.Model.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "proveedores")
public class proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    @Column(name = "nombre_marca")
    private String nombreMarca;
    private String email;
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @OneToMany(mappedBy = "proveedor")
    List<producto>productos;
}
