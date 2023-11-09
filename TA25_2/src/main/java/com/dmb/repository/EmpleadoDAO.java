package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entiteis.Empleado;
@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, String>{

}
