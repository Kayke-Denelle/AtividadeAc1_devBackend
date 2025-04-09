package com.example.projetoescola.Services;

import java.util.List;

import com.example.projetoescola.DTO.CursoDto;
import com.example.projetoescola.DTO.CursoRequestDto;

public interface CursoService {
    CursoDto salvar(CursoRequestDto curso);
    List<CursoDto> obterTodos();
}
