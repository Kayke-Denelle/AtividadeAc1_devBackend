package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	@Transactional
	public CommandLineRunner init(
		@Autowired CursoRepository cursoRepository, 
		@Autowired CategoriaCursoRepository categoriaCursoRepository, 
		@Autowired PessoaRepository pessoaRepository
	) {
		return args -> {
			// Criando cursos
			Curso curso1 = cursoRepository.salvar(new Curso(null, "teste", 2000));
			Curso curso2 = cursoRepository.salvar(new Curso(null, "teste2", 2050));

			// Criando uma categoria de curso
			CategoriaCurso categ = categoriaCursoRepository.salvar(new CategoriaCurso(null, "Informática"));

			// Criando uma pessoa
			Pessoa p1 = pessoaRepository.salvar(new Pessoa(null, "Kayke", null));

			// Listando cursos
			System.out.println("--------------Listando Cursos-----------------");
			List<Curso> listaCursos = cursoRepository.obterTodos();
			listaCursos.forEach(System.out::println);

			// Listando categorias de cursos
			System.out.println("--------------Listando Categorias de Cursos-----------------");
			List<CategoriaCurso> listaCategoriaCursos = categoriaCursoRepository.obterTodos();
			listaCategoriaCursos.forEach(System.out::println);

			// Associando um curso a uma categoria
			System.out.println("----- Vincular Curso à Categoria -----");
			curso1.setCategoriaCurso(categ);
			cursoRepository.salvar(curso1);

			// Associando uma pessoa a cursos
			System.out.println("----- Vincular Pessoa a Cursos -----");
			p1.setCursos(List.of(curso1, curso2)); // Pessoa agora está vinculada a dois cursos
			pessoaRepository.salvar(p1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}
}
