package com.anotacoes.caderno.repository;


import com.anotacoes.caderno.entity.CadernoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadernoRepository extends JpaRepository<CadernoEntity, Long> {

}
