package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.Trader;

public interface TraderRepository extends JpaRepository<Trader, Long>{
	Trader findByEmail(String email);
	boolean existsByEmail(String email);
}
