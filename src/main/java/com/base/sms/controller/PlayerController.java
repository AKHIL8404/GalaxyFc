package com.base.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.base.sms.entity.Player;
import com.base.sms.service.PlayerService;

@Controller
public class PlayerController {
	
	private PlayerService playerservice;
	
	@Autowired
	PlayerController(PlayerService playerservice){
		super();
		this.playerservice =playerservice;
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/players")
	public String listPlayer(Model model) {
		model.addAttribute("players", playerservice.getAllPlayers());
		return "players";
	}
	
	@GetMapping("/player/new")
	public String createPlayer(Model model) {
		Player player = new Player();
		model.addAttribute("player",player);
		return "create_player";
	}
	
	@PostMapping("/players")
	public String savePlayer(@ModelAttribute("player") Player player, Model model) {
		if(playerservice.existsById(player.getId())) {
			model.addAttribute("error", "Player Id already exists");
			return "create_player";
		}
		if(playerservice.existsByEmail(player.getEmail())) {
			model.addAttribute("error", "Email Already Exists");
			return "create_player";
		}
		playerservice.savePlayer(player);
		return "redirect:/players";
	}
	
	@GetMapping("/players/edit/{id}")
	public String editPlayer(@PathVariable Integer id, Model model) {
		model.addAttribute("player", playerservice.getPlayerById(id));
		return "edit_player";
	}
	
	@PostMapping("/players/{id}")
	public String updatePlayer(@PathVariable Integer id, @ModelAttribute("player") Player player, Model model) {
		Player existingPlayer = playerservice.getPlayerById(id);
		
		if(!existingPlayer.getEmail().equals(player.getEmail()) && playerservice.existsByEmail(player.getEmail())) {
			model.addAttribute("error", "Email Already Exists");
			return "edit_player";
		}
		existingPlayer.setName(player.getName());
		existingPlayer.setAge(player.getAge());
		existingPlayer.setCountry(player.getCountry());
		existingPlayer.setEmail(player.getEmail());
		existingPlayer.setPosition(player.getPosition());
		playerservice.savePlayer(existingPlayer);
		
		return "redirect:/players";
	}
	
	@GetMapping("/players/{id}")
	public String deletePlayer(@PathVariable Integer id) {
		playerservice.deletePlayerById(id);
		return "redirect:/players";
	}
	
	@GetMapping("/find")
	public String searchPlayer(@RequestParam(value = "id", required = false) Integer id, Model model) {
		if(id == null) {
			model.addAttribute("error", "Enter the Player Id");
			return "search";
		}
		Player player = playerservice.getPlayerById(id);
		if(player == null) {
			model.addAttribute("error", "No Player Found with ID : "+id);
		}else {
			model.addAttribute("player", player);
		}
		return "search";
	}
}
