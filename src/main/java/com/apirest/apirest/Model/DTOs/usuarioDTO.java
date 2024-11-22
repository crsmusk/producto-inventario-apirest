package com.apirest.apirest.Model.DTOs;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class usuarioDTO {
    private Long id;
    private String userName;
    private String password;
    private List<String>roles;
}
