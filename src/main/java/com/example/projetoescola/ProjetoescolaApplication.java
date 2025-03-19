package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetoescola.models.Aluno;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.AlunoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

    @Bean
    @Transactional
    public CommandLineRunner init(
        @Autowired CursoRepository cursoRepository,
        @Autowired AlunoRepository alunoRepository
    ) {
        return args -> {
            // Criando cursos
            Curso curso1 = cursoRepository.salvar( new Curso(null, "Ciência da Computação"));
            Curso curso2 = cursoRepository.salvar (new Curso(null, "Engenharia de Software"));


            // Criando alunos e associando aos cursos
            Aluno aluno1 = alunoRepository.salvar(new Aluno(null, "Kayke", 2024, curso1));
            Aluno aluno2 = alunoRepository.salvar( new Aluno(null, "João", 2023, curso2));

            // Listando cursos
            System.out.println("-------------- Listando Cursos ----------------");
            List<Curso> listaCursos = cursoRepository.obterTodos();
                listaCursos.forEach(System.out::println);

            // Listando alunos
            System.out.println("-------------- Listando Alunos ----------------");
            List<Aluno> listaAlunos = alunoRepository.obterTodos();
            listaAlunos.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoescolaApplication.class, args);
    }
}