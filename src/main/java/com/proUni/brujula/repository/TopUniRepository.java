package com.proUni.brujula.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.BolsaTrabajo;
import com.proUni.brujula.models.TipsGenerales;
import com.proUni.brujula.models.UniTop;

@Repository
public interface TopUniRepository extends JpaRepository<UniTop, Long>{

}
