package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entities.Articulo;

@Repository
public interface ArticuloDAO extends JpaRepository<Articulo, Integer>{

}
