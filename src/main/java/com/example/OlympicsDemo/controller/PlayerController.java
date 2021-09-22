package com.example.OlympicsDemo.controller;

import com.example.OlympicsDemo.converter.CountryConverter;
import com.example.OlympicsDemo.converter.GamesConverter;
import com.example.OlympicsDemo.converter.PlayerConverter;
import com.example.OlympicsDemo.dto.CountryDTO;
import com.example.OlympicsDemo.dto.GamesDTO;
import com.example.OlympicsDemo.dto.PlayerDTO;
import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import com.example.OlympicsDemo.entity.Player;
import com.example.OlympicsDemo.service.CountryService;
import com.example.OlympicsDemo.service.GameService;
import com.example.OlympicsDemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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

		theModel.addAttribute("countries",countryDTOList);
		theModel.addAttribute("game",gamesDTOList);
		theModel.addAttribute("players", playerDTO);

		return "player-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId,
									Model theModel) {
		// get the employee from the service
//		Player thePlayer = playerService.findById(theId);
//		List<Country> theCountry= countryService.findAll();
//
//		List<Games> theGame= gameService.findAll();

		//Country theCountry = countryService.findById(theId);


		PlayerDTO playerDTO=new PlayerConverter().entityToDto(playerService.findById(theId));


		GamesConverter gamesConverter=new GamesConverter();
		List<GamesDTO> gamesDTOList=gamesConverter.entityToDto(gameService.findAll());

		CountryConverter countryConverter=new CountryConverter();
		List<CountryDTO> countryDTOList=countryConverter.entityToDto(countryService.findAll());

		theModel.addAttribute("players", playerDTO);
		theModel.addAttribute("playerGames",playerDTO.getGames());
		//theModel.addAttribute("countries", thePlayer);

		theModel.addAttribute("countries",countryDTOList);
		theModel.addAttribute("game",gamesDTOList);




		// send over to our form
		return "player-form";
	}


	@PostMapping("/save")
	public String savePlayer(@Valid @ModelAttribute("players") Player thePlayer, BindingResult bindingResult,
							 Model theModel, @ModelAttribute("playerGames") List<Games> playerGames)
	{

//		boolean isChecked = false;
//		System.out.println("-------isTermsChecked: "+isTermsChecked);
//		//check is checkbox checked
//		if (isTermsChecked == null) {
//			theModel.addAttribute("isChecked", isChecked);
//			theModel.addAttribute("errorTermsChecked", "Please select atleast one game");
//		}else{
//			isChecked = true;
//			theModel.addAttribute("isChecked", isChecked);
//			theModel.addAttribute("errorTermsChecked", "");
//		}

//		if (bindingResult.hasErrors() || isTermsChecked == null) {
//			modelAndView.setViewName("view_addUser");
//		} else {
//			//add user ...
//			modelAndView.setViewName("view_addUser");
//		}
		System.out.println("------------------Player "+thePlayer);
		System.out.println("-------Player Games: "+thePlayer.getGames());

		GamesConverter gamesConverter=new GamesConverter();
		List<GamesDTO> gamesDTOList=gamesConverter.entityToDto(gameService.findAll());

		CountryConverter countryConverter=new CountryConverter();
		List<CountryDTO> countryDTOList=countryConverter.entityToDto(countryService.findAll());

		//theModel.addAttribute("countries", thePlayer);

		theModel.addAttribute("countries",countryDTOList);
		theModel.addAttribute("game",gamesDTOList);
//|| isTermsChecked == null)
		if(bindingResult.hasErrors())
		{

			System.out.println("---------------ERROR");
			return "player-form";
		}
		playerService.save(thePlayer);


		// use a redirect to prevent duplicate submissions
		return "redirect:/players/list";
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









