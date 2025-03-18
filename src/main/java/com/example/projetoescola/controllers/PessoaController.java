package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/dados")
    public List<Pessoa> obterTodos() {
        return pessoaRepository.obterTodos();
    }

    @GetMapping("/buscar")
    public List<Pessoa> obterPorNome(@RequestParam String nome) {
        return pessoaRepository.obterPorNome(nome);
    }

    @PostMapping()
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.salvar(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa editar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaEditada = pessoaRepository.editar(id, pessoa);
        if (pessoaEditada == null) {
            throw new RuntimeException("Pessoa não encontrada para atualização.");
        }
        return pessoaEditada;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean deletado = pessoaRepository.deletar(id);
        if (deletado) {
            return "Pessoa deletada com sucesso!";
        } else {
            return "Pessoa não encontrada!";
        }
    }
}
