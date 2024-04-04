package com.anotacoes.caderno.service;


import com.anotacoes.caderno.entity.CadernoEntity;
import com.anotacoes.caderno.repository.CadernoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadernoService {

    private CadernoRepository cadernoRepository;

    public List<CadernoEntity> buscarTodos(){
        return cadernoRepository.findAll();
    }

    public CadernoEntity buscarPorId(Long id){
        return cadernoRepository.findById(id).orElseThrow();

    }

    public CadernoEntity salvar(CadernoEntity caderno) {
        return cadernoRepository.save(caderno);
    }
    public void removerPorId(Long id) {
        cadernoRepository.deleteById(id);
    }

    public CadernoEntity atualizar(Long id, CadernoEntity caderno){
        buscarPorId(id);
        caderno.setId(id);
        return cadernoRepository.save(caderno);
    }

}
