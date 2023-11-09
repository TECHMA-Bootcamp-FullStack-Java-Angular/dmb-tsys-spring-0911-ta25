package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Pelicula;

@Repository
public interface PeliculaDAO extends JpaRepository<Pelicula, Integer>{
}
