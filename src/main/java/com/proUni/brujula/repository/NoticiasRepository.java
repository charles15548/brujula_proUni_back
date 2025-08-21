package com.proUni.brujula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proUni.brujula.models.Noticias;
@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Long> {
	
}
