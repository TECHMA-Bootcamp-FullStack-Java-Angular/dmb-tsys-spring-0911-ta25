package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entities.Almacen;

@Repository
public interface AlmacenDAO extends JpaRepository<Almacen, Integer>{

}
