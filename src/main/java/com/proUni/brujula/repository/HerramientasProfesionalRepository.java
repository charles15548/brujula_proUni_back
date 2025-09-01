package com.proUni.brujula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.HerramientasProfesional;
import com.proUni.brujula.models.Noticias;

import DTO.NoticiasProjection;

@Repository
public interface HerramientasProfesionalRepository extends JpaRepository<HerramientasProfesional, Long> {	
	  List<HerramientasProfesional> findByDesarrolloProfesionalId(Long dProfesionalId);
}
