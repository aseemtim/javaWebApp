package ca.lambton.termProjectc0839829;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PageCountController.class)
public class PageCountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PageCounter pageCounter;
	
	@MockBean
	private PlayerRepository playerRepo;
	
	@Test
	public void currentCountTest() throws Exception{
		Mockito.when(pageCounter.getCounter()).thenReturn(1);
		mockMvc.perform(get("/currentcount"))
		.andExpect(status().isOk())
		.andExpect(content().json("1"));
	}
	
	@Test
	public void usertCountTest() throws Exception{
		Mockito.when(playerRepo.count()).thenReturn((long) 1);
		mockMvc.perform(get("/usercount"))
		.andExpect(status().isOk())
		.andExpect(content().json("1"));
	}
	
	@Test
	public void findByAgeTest() throws Exception{
		Player expectedUser = new Player(null, "Mike", "mike@mike.com", 25);
		String expectedJson = "{\"id\":null, \"name\":\"Mike\",\"email\":\"mike@mike.com\",\"age\":25}";
		Mockito.when(playerRepo.findByAge(25)).thenReturn(expectedUser);
		mockMvc.perform(get("/findbyage?age=25"))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedJson));
		
	}
	
}
