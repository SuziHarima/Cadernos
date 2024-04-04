package com.anotacoes.caderno.controller;


import com.anotacoes.caderno.entity.NotaEntity;
import com.anotacoes.caderno.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;


    @GetMapping
    public ResponseEntity<List<NotaEntity>> listarTodos(){
        List<NotaEntity> notas = notaService.buscarTodos();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaEntity> listarPorId(@PathVariable Long id){
        NotaEntity nota = notaService.buscarPorId(id);
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotaEntity> salvar(@RequestBody NotaEntity nota){
        NotaEntity notaSalva = notaService.salvar(nota);
        return new ResponseEntity<>(notaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id){
        notaService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody NotaEntity nota){
        notaService.atualizar(id, nota);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
