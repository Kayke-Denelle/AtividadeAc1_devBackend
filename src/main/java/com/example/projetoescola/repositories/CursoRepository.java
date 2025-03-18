package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar(Curso curso) {
        return entityManager.merge(curso);
    }
    @Transactional
    public Curso editar(Long id, Curso curso) {
        Curso cursoExistente = entityManager.find(Curso.class, id);
        if (cursoExistente != null) {
            curso.setId(id);
            return entityManager.merge(curso);
        }
        return null; 
    }

    @Transactional
    public boolean deletar(Long id) {
        Curso curso = entityManager.find(Curso.class, id);
        if (curso != null) {
            entityManager.remove(curso);
            return true;
        }
        return false;
    }
    
    public List<Curso> obterPorNome(String nome){
    String jpql = " select c from Curso c where c.nome like :nome";
    TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
    query.setParameter("nome", "%" + nome + "%");
    return query.getResultList();
    }

    public List<Curso> obterTodos(){
        return entityManager.createQuery("From Curso", Curso.class).getResultList();
    }
}
