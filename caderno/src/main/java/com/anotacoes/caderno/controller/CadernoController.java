package com.anotacoes.caderno.controller;

import com.anotacoes.caderno.entity.CadernoEntity;
import com.anotacoes.caderno.service.CadernoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cadernos")
public class CadernoController {

    private final CadernoService cadernoService;


    @GetMapping
    public ResponseEntity<List<CadernoEntity>> listarTodos(){
        List<CadernoEntity> cadernos = cadernoService.buscarTodos();
        return new ResponseEntity<>(cadernos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadernoEntity> listarPorId(@PathVariable Long id){
        CadernoEntity caderno = cadernoService.buscarPorId(id);
        return new ResponseEntity<>(caderno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CadernoEntity> salvar(@RequestBody CadernoEntity caderno){
        CadernoEntity cadernoSalvo = cadernoService.salvar(caderno);
        return new ResponseEntity<>(cadernoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        cadernoService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody CadernoEntity caderno){
        cadernoService.atualizar(id, caderno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
