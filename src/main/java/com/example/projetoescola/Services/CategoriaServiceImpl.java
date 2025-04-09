package com.example.projetoescola.Services;

import com.example.projetoescola.DTO.CategoriaDto;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaCursoRepository categoriaRepository;

    @Override
    public List<CategoriaDto> obterTodos() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> new CategoriaDto(
                        categoria.getId(),
                        categoria.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto salvar(CategoriaDto categoriaDto) {
        CategoriaCurso categoria = new CategoriaCurso();
        categoria.setNome(categoriaDto.getNome());
        
        categoria = categoriaRepository.save(categoria);
        
        return new CategoriaDto(categoria.getId(), categoria.getNome());
    }
}