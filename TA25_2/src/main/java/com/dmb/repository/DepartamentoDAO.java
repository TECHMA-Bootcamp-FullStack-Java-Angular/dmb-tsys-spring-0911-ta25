package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entiteis.Departamento;
@Repository
public interface DepartamentoDAO extends JpaRepository<Departamento, Integer> {

}