package com.proUni.brujula.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.BolsaTrabajo;

@Repository
public interface BolsaTrabajoRepository extends JpaRepository<BolsaTrabajo, Long>{

}
