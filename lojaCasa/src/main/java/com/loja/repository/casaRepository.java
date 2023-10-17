package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.model.Casa;

@Repository
public interface casaRepository extends JpaRepository<Casa, Integer>{

}
