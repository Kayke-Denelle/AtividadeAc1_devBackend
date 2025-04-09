package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.DTO.CategoriaDto;
import com.example.projetoescola.Services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public List<CategoriaDto> obterTodos() {
        return categoriaService.obterTodos();
    }

    @PostMapping()
    public CategoriaDto salvar(@RequestBody CategoriaDto categoria) {
        return categoriaService.salvar(categoria);
    }
}