package com.anotacoes.caderno.service;


import com.anotacoes.caderno.entity.NotaEntity;
import com.anotacoes.caderno.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;

    public List<NotaEntity> buscarTodos(){
        return notaRepository.findAll();
    }

    public NotaEntity buscarPorId(Long id){
        return notaRepository.findById(id).orElseThrow();

    }

    public NotaEntity salvar(NotaEntity nota) {
        return notaRepository.save(nota);
    }
    public void removerPorId(Long id) {
        notaRepository.deleteById(id);
    }

    public NotaEntity atualizar(Long id, NotaEntity nota){
        buscarPorId(id);
        nota.setId(id);
        return notaRepository.save(nota);
    }
}
