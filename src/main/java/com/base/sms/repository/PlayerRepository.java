package com.base.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.sms.entity.Player;


public interface PlayerRepository extends JpaRepository<Player,Integer> {
	boolean existsByEmail(String email);
}
