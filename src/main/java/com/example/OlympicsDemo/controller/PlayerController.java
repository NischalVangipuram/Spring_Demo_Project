package com.example.OlympicsDemo.controller;

import com.example.OlympicsDemo.converter.CountryConverter;
import com.example.OlympicsDemo.converter.GamesConverter;
import com.example.OlympicsDemo.converter.PlayerConverter;
import com.example.OlympicsDemo.converter.UserConverter;
import com.example.OlympicsDemo.dto.CountryDTO;
import com.example.OlympicsDemo.dto.GamesDTO;
import com.example.OlympicsDemo.dto.PlayerDTO;
import com.example.OlympicsDemo.dto.UserDTO;
import com.example.OlympicsDemo.entity.*;
import com.example.OlympicsDemo.exceptions.PlayerAlreadyExistException;
import com.example.OlympicsDemo.service.CountryService;
import com.example.OlympicsDemo.service.GameService;
import com.example.OlympicsDemo.service.PlayerService;
import com.example.OlympicsDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.security.SecureRandom;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/players")
public class PlayerController {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private PlayerService playerService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserService userService;

//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	public PlayerController(PlayerService thePlayerService) {
//		playerService = thePlayerService;
//	}
	// add mapping for "/list"
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		//System.out.println("----------------------In InitBinder");
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}


	@GetMapping("/list")
	public String listPlayers(Model theModel) {


		PlayerConverter playerConverter=new PlayerConverter();
		List<PlayerDTO> playerDTOList=playerConverter.entityToDto(playerService.findAll());
		// get players from db
		//List<Player> thePlayers = playerService.findAll();
		//List<Country> theCountry= countryService.findAll();
		// add to the spring model
		theModel.addAttribute("players", playerDTOList);
		//theModel.addAttribute("countries", theCountry);
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("--name--"+ name);

		User user=userService.findUsername(name);


		Player player=playerService.findPlayer(name);
		System.out.println("---player in /list "+player);
		theModel.addAttribute("myPlayerDetails",player);



		return "home";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//System.out.println("qwerty");
		// create model attribute to bind form data
		//Player thePlayer = new Player();

		PlayerConverter playerConverter=new PlayerConverter();
		PlayerDTO playerDTO=playerConverter.entityToDto(new Player());
		//		List<Country> theCountry= countryService.findAll();
//		List<Games> theGame= gameService.findAll();


		GamesConverter gamesConverter=new GamesConverter();
		List<GamesDTO> gamesDTOList=gamesConverter.entityToDto(gameService.findAll());

		CountryConverter countryConverter=new CountryConverter();
		List<CountryDTO> countryDTOList=countryConverter.entityToDto(countryService.findAll());

		UserConverter userConverter=new UserConverter();
		UserDTO userDTO=userConverter.entityToDto(new User());

		theModel.addAttribute("countries",countryDTOList);
		theModel.addAttribute("game",gamesDTOList);
		theModel.addAttribute("players", playerDTO);
		theModel.addAttribute("user", userDTO);



		return "player-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int thePlayerId,
									Model theModel) {
		// get the employee from the service


		PlayerDTO playerDTO=new PlayerConverter().entityToDto(playerService.findById(thePlayerId));

		UserDTO userDTO=new UserConverter().entityToDto(userService.findById(playerDTO.getUser().getUserId()));


		playerDTO.getUser().setPassword(userDTO.getPassword().substring(6));
		System.out.println("user id here_____________"+playerDTO.getUser().getUserId());
		GamesConverter gamesConverter=new GamesConverter();
		List<GamesDTO> gamesDTOList=gamesConverter.entityToDto(gameService.findAll());

		CountryConverter countryConverter=new CountryConverter();
		List<CountryDTO> countryDTOList=countryConverter.entityToDto(countryService.findAll());

		theModel.addAttribute("players", playerDTO);
		theModel.addAttribute("playerGames",playerDTO.getGames());
		//theModel.addAttribute("countries", thePlayer);

		theModel.addAttribute("countries",countryDTOList);
		theModel.addAttribute("game",gamesDTOList);
		theModel.addAttribute("user",userDTO);




		// send over to our form
		return "player-form";
	}


	@PostMapping("/save")
	public String savePlayer(  @Valid @ModelAttribute("players") Player thePlayer, BindingResult bindingResult,
							 Model theModel) {

		thePlayer.setPlayerName(thePlayer.getUser().getUsername());

		System.out.println("------------------Player " + thePlayer);
		//System.out.println("-------Player Games: "+thePlayer.getGames());
		//thePlayer.setUser(theUser);
		thePlayer.getUser().setEnabled(1);
		System.out.println("------USER from player object: " + thePlayer.getUser());
		System.out.println("---------authority object: "+thePlayer.getUser().getTheAuthority());

		//System.out.println("user from MA "+theUser);
		List<Games> playerGames = thePlayer.getGames();


		GamesConverter gamesConverter = new GamesConverter();
		List<GamesDTO> gamesDTOList = gamesConverter.entityToDto(gameService.findAll());

		CountryConverter countryConverter = new CountryConverter();
		List<CountryDTO> countryDTOList = countryConverter.entityToDto(countryService.findAll());

		//theModel.addAttribute("countries", thePlayer);

		theModel.addAttribute("countries", countryDTOList);
		theModel.addAttribute("game", gamesDTOList);
		if (playerGames.isEmpty()) {
			theModel.addAttribute("errorTermsChecked", "Please select atleast one game");
			return "player-form";
		}

		theModel.addAttribute("errorTermsChecked", "");

		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getAllErrors());
			System.out.println("---------------ERROR");
			return "player-form";
		}
		//theUser.setEnabled(1);
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder(10, new SecureRandom());

//		thePlayer.getUser().setPassword(bCryptPasswordEncoder.encode(thePlayer.getUser().getPassword()));
//	//	thePlayer.getUser().setPassword(passwordEncoder.encode(thePlayer.getUser().getPassword()));

		System.out.println("temp name " + thePlayer.getPlayerName());
		if (!(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_PLAYER")) || (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))))) {

			try {
thePlayer.getUser().setTheAuthority(new Authority(1));
				Player tempPlayer = playerService.findPlayer(thePlayer.getPlayerName());
				System.out.println("---temp Player " + tempPlayer);

				if (tempPlayer != null) {
					System.out.println("--------in Exception");
					throw new PlayerAlreadyExistException("Player with " + tempPlayer + " already exist");
				}
			} catch (PlayerAlreadyExistException e) {
				theModel.addAttribute("playerAlreadyExist", "Player Name already exists");
				return "player-form";

			}
		}


			thePlayer.getUser().setPassword("{noop}" + thePlayer.getUser().getPassword());

		System.out.println("Authority---------"+thePlayer.getUser().getTheAuthority());

			System.out.println("before user save");
			userService.save(thePlayer.getUser());
			System.out.println("after user save");
			playerService.save(thePlayer);
			//theUser.setPassword("{noop}"+theUser.getPassword());
			System.out.println("after player save");

			// use a redirect to prevent duplicate submissions
			//return "redirect:/players/list";
			return "redirect:/players/check";

	}

	@GetMapping("/check")
	public String checkRole() {

		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
			return "redirect:/players/list";

		}
return "fancy-login";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("playerId") int theId) {

		// delete the players
		playerService.deleteById(theId);

		// redirect to /players/list
		return "redirect:/players/list";

	}
	@GetMapping("/error")
	public String error()
	{
		return "error";
	}
}









