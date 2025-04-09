package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Curso;



@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // select * from Curso where nome = ?
    public List<Curso> findByNome(String nome);

    // select * from Curso where nome like ?
    public List<Curso> findByNomeLike(String nome);
}