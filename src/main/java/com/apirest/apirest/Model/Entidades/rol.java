package com.apirest.apirest.Model.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_rol",unique = true)
    private String nombreRol;
    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "rol_permiso",
                    joinColumns = @JoinColumn(name = "rol_id"),
                    inverseJoinColumns = @JoinColumn(name = "permiso_id")
            )
    List<permiso> permisos;
}
