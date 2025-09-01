package com.proUni.brujula.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.BolsaTrabajo;
import com.proUni.brujula.models.TipsGenerales;

@Repository
public interface TipsGeneralesRepository extends JpaRepository<TipsGenerales, Long>{

}
