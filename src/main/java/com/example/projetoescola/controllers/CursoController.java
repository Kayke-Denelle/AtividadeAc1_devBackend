package com.example.projetoescola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.DTO.CursoDto;
import com.example.projetoescola.DTO.CursoRequestDto;
import com.example.projetoescola.Services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    /*@GetMapping()
    public List<Curso> obterTodos() {
        return cursoRepository.findAll();
    }*/

    @PostMapping()
    public CursoDto salvar(@RequestBody CursoRequestDto curso) {
        return cursoService.salvar(curso);
    }
}
    

