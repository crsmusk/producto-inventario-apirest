package com.apirest.apirest.Model.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class producto {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 private double precio;
 private int  cantidad;
 @ManyToOne(cascade = CascadeType.MERGE)
 @JoinColumn(name = "categoria_id")
 private categoria categoria;
 @ManyToOne(cascade = CascadeType.MERGE)
 @JoinColumn(name = "proveedor_id")
 private proveedor proveedor;
}
