package com.anotacoes.caderno.repository;


import com.anotacoes.caderno.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
}
