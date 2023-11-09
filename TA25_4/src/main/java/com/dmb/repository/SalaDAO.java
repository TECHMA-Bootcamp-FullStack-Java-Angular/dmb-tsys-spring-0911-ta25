package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Sala;

@Repository
public interface SalaDAO extends JpaRepository<Sala, Integer>{

}