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
@Table(name = "usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "is_enable")
    private Boolean isEnable=true;
    @Column(name = "account_no_locked")
    private Boolean accountNoLoked=true;
    @Column(name = "account_no_expired")
    private Boolean accountNoExpired=true;
    @Column(name = "credential_no_expired")
    private Boolean CredentialNoExpired=true;
    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id"),
                    inverseJoinColumns = @JoinColumn(name = "rol_id")
            )
    List<rol>roles;
}
