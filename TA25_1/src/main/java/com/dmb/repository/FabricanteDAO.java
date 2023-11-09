package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entities.Fabricante;
@Repository
public interface FabricanteDAO extends JpaRepository<Fabricante, Integer>{
}
