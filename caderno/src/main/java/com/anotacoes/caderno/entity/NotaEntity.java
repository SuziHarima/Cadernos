package com.anotacoes.caderno.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Table(name = "notas")
@Entity
@Data
@NoArgsConstructor
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "caderno_id", nullable = false)
    private CadernoEntity caderno;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;


}
