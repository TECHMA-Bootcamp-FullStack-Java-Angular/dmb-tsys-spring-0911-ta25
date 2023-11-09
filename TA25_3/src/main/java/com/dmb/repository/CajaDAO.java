package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Caja;

@Repository
public interface CajaDAO extends JpaRepository<Caja, String> {

}
