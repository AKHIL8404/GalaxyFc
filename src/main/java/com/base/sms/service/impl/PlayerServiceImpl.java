package com.base.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.sms.entity.Player;
import com.base.sms.repository.PlayerRepository;
import com.base.sms.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(Integer id) {
		
		return playerRepository.findById(id).orElse(null);
	}

	@Override
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public boolean existsById(Integer id) {
		return playerRepository.existsById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return playerRepository.existsByEmail(email);
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public void deletePlayerById(Integer id) {
		playerRepository.deleteById(id);
	}

}
