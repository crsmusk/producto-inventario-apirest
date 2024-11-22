package com.apirest.apirest.Model.DTOs;

import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class rolDTO {
    private Long id;
    private String nomreRol;
    private List<String> permisos;
}
