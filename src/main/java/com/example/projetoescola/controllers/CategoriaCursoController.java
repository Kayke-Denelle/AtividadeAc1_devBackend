package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@RestController
@RequestMapping("/Categorias")
public class CategoriaCursoController {
    @Autowired
    private CategoriaCursoRepository CategoriaCursoRepository;

    @GetMapping("/dados")
    public List<CategoriaCurso> obterTodos() {
        return CategoriaCursoRepository.obterTodos();
    }

    @GetMapping("/buscar")
    public List<CategoriaCurso> obterPorNome(@RequestParam String nome) {
        return CategoriaCursoRepository.obterPorNome(nome);
    }

    @PostMapping()
    public CategoriaCurso salvar(@RequestBody CategoriaCurso categoriaCurso) {
        return CategoriaCursoRepository.salvar(categoriaCurso);
    }

    @PutMapping("/{id}")
    public CategoriaCurso editar(@PathVariable Long id, @RequestBody CategoriaCurso categoriaCurso) {
        CategoriaCurso CategoriaCursoEditado = CategoriaCursoRepository.editar(id, categoriaCurso);
        if (CategoriaCursoEditado == null) {
            throw new RuntimeException("Curso não encontrado para atualização.");
        }
        return CategoriaCursoEditado;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean deletado = CategoriaCursoRepository.deletar(id);
        if (deletado) {
            return "Categoria deletado com sucesso!";
        } else {
            return "Categoria não encontrado!";
        }
    }
}
