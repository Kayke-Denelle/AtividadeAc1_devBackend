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

import com.example.projetoescola.models.Aluno;
import com.example.projetoescola.repositories.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/dados")
    public List<Aluno> obterTodos() {
        return alunoRepository.obterTodos();
    }

    @GetMapping("/buscar")
    public List<Aluno> obterPorNome(@RequestParam String nome) {
        return alunoRepository.obterPorNome(nome);
    }

    @PostMapping()
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoRepository.salvar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno editar(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno pessoaEditada = alunoRepository.editar(id, aluno);
        if (pessoaEditada == null) {
            throw new RuntimeException("Pessoa não encontrada para atualização.");
        }
        return pessoaEditada;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean deletado = alunoRepository.deletar(id);
        if (deletado) {
            return "Aluno deletada com sucesso!";
        } else {
            return "Aluno não encontrado!";
        }
    }
}
