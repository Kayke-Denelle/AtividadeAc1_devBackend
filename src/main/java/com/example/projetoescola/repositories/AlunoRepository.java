package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class AlunoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno salvar(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    @Transactional
    public Aluno editar(Long id, Aluno aluno) {
        Aluno alunoExistente = entityManager.find(Aluno.class, id);
        if (alunoExistente != null) {
            aluno.setId(id);
            return entityManager.merge(aluno);
        }
        return null; 
    }

    @Transactional
    public boolean deletar(Long id) {
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            entityManager.remove(aluno);
            return true;
        }
        return false;
    }

    public List<Aluno> obterPorNome(String nome) {
        String jpql = "SELECT a FROM Aluno a WHERE a.nome LIKE :nome";
        TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Aluno> obterTodos() {
        return entityManager.createQuery("FROM Aluno", Aluno.class).getResultList();
    }
}
