package ca.lambton.termProjectc0839829;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
	@Autowired
	private PageCounter pageCounter;
	@Autowired
	private PlayerRepository playerRepo;
	
	@GetMapping("/createuser")
	public String userForm(Model model) {
		pageCounter.increaseCounter();
		model.addAttribute("count", pageCounter.getCounter());
		model.addAttribute("player", new Player());
		return "userform";
	}
	
	@PostMapping("/createuser")
	public String createPlayer(@Valid Player toSave, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "userform";
		} else {
			this.playerRepo.save(toSave);
			return "saved";
		}
	}
	
	@GetMapping("/allusers")
	public String listAllUsers(Model model) {
		pageCounter.increaseCounter();
		model.addAttribute("count", pageCounter.getCounter());
		model.addAttribute("users", this.playerRepo.findAll());
		return "allusers";
	}
	
	@GetMapping("/")
	public String pageCount(Model model) {
		pageCounter.increaseCounter();
		model.addAttribute("count", pageCounter.getCounter());
		return "welcome";
	}
}
