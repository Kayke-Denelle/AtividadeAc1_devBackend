package com.example.projetoescola.Services;

import java.util.List;

import com.example.projetoescola.DTO.CategoriaDto;

public interface CategoriaService {
    List<CategoriaDto> obterTodos();
    CategoriaDto salvar(CategoriaDto categoriaDto);
}