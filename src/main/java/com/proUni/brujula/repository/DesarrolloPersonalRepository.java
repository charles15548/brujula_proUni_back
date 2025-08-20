package com.proUni.brujula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.Desarrollo_Personal;
import com.proUni.brujula.models.Noticias;
@Repository
public interface DesarrolloPersonalRepository extends JpaRepository<Desarrollo_Personal, Long> {
	
}
