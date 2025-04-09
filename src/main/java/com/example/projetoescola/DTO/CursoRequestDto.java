package com.example.projetoescola.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoRequestDto {
    private String nome;
    private Integer cargaHoraria;
    private Integer categoriaCursoId;
}
