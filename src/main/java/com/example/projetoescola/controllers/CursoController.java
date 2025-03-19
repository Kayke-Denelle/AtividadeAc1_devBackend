package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CursoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/dados")
    public List<Curso> obterTodos() {
        return cursoRepository.obterTodos();
    }

    @GetMapping("/buscar")
    public List<Curso> obterPorNome(@RequestParam String nome) {
        return cursoRepository.obterPorNome(nome);
    }

    @PostMapping()
    public Curso salvar(@RequestBody Curso curso) {
        return cursoRepository.salvar(curso);
    }

    @PutMapping("/{id}")
    public Curso editar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso cursoEditado = cursoRepository.editar(id, curso);
        if (cursoEditado == null) {
            throw new RuntimeException("Curso não encontrado para atualização.");
        }
        return cursoEditado;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean deletado = cursoRepository.deletar(id);
        if (deletado) {
            return "Curso deletado com sucesso!";
        } else {
            return "Curso não encontrado!";
        }
    }
}
    

