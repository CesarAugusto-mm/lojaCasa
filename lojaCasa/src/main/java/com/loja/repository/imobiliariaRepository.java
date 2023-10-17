package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.model.Imobiliaria;

@Repository
public interface imobiliariaRepository extends JpaRepository<Imobiliaria, Integer>{

}
