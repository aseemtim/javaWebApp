package ca.lambton.termProjectc0839829;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageCountController {
	@Autowired
	private PageCounter currentCount;
	
	// injected two times(in welcomeController too)
	@Autowired
	private PlayerRepository playerRepo;
	
	@GetMapping("/currentcount")
	public Integer viewCount() {
		return currentCount.getCounter();
	}
	
	@GetMapping("/usercount")
	public Long listAllUsers() {
		return playerRepo.count();
	}
	
	@GetMapping("/findbyage")
	public Player findByAge(@RequestParam Integer age) {
		return this.playerRepo.findByAge(age);
	}
}
