package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PessoaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    @Transactional
    public Pessoa editar(Long id, Pessoa pessoa) {
        Pessoa pessoaExistente = entityManager.find(Pessoa.class, id);
        if (pessoaExistente != null) {
            pessoa.setId(id);
            return entityManager.merge(pessoa);
        }
        return null; 
    }

    @Transactional
    public boolean deletar(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
            return true;
        }
        return false;
    }

    public List<Pessoa> obterPorNome(String nome) {
        String jpql = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome";
        TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Pessoa> obterTodos() {
        return entityManager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }
}
