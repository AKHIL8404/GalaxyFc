package com.base.sms.service;

import java.util.List;

import com.base.sms.entity.Player;

public interface PlayerService {
	
	List<Player> getAllPlayers();
	
	Player getPlayerById(Integer id);
	
	Player savePlayer(Player player);
	
	boolean existsById(Integer id);
	
	boolean existsByEmail(String email);
	
	Player updatePlayer(Player player);
	
	void deletePlayerById(Integer id);
}
