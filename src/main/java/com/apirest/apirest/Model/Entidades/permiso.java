package com.apirest.apirest.Model.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permisos")
public class permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_permiso")
    private String nombrePermiso;

}
