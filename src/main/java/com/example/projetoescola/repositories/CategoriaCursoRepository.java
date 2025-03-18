package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso salvar(CategoriaCurso categoriaCurso) {
        return entityManager.merge(categoriaCurso);
    }
    @Transactional
    public CategoriaCurso editar(Long id, CategoriaCurso CategoriaCurso) {
        CategoriaCurso categoriaExistente = entityManager.find(CategoriaCurso.class, id);
        if (categoriaExistente != null) {
            CategoriaCurso.setId(id);
            return entityManager.merge(CategoriaCurso);
        }
        return null; 
    }

    @Transactional
    public boolean deletar(Long id) {
        CategoriaCurso CategoriaCurso = entityManager.find(CategoriaCurso.class, id);
        if (CategoriaCurso != null) {
            entityManager.remove(CategoriaCurso);
            return true;
        }
        return false;
    }
    
    public List<CategoriaCurso> obterPorNome(String nome){
    String jpql = " select c from CategoriaCurso c where c.nome like :nome";
    TypedQuery<CategoriaCurso> query = entityManager.createQuery(jpql, CategoriaCurso.class);
    query.setParameter("nome", "%" + nome + "%");
    return query.getResultList();
    }

    public List<CategoriaCurso> obterTodos(){
        return entityManager.createQuery("From CategoriaCurso", CategoriaCurso.class).getResultList();
    }
}
