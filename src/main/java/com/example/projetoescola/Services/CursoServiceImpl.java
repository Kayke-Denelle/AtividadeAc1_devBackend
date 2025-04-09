package com.example.projetoescola.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoescola.Configs.RegraNegocioException;
import com.example.projetoescola.DTO.CursoDto;
import com.example.projetoescola.DTO.CursoRequestDto;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public CursoDto salvar(CursoRequestDto curso) {
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(
                curso.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        Curso c = new Curso(null,
                curso.getNome(),
                curso.getCargaHoraria());
        c.setCategoriaCurso(categoriaCurso);
        c = cursoRepository.save(c);
        return new CursoDto(c.getId(), c.getNome());
    }
    
     @Override
    public List<CursoDto> obterTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(curso -> new CursoDto(curso.getId(), curso.getNome()))
                .collect(Collectors.toList());
    }
}


    
