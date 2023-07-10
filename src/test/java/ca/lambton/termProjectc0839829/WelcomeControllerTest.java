package ca.lambton.termProjectc0839829;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.eq;


@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PageCounter pageCounter;
	@MockBean
	private PlayerRepository playerRepo;
	
	@Test
	public void createuserTest() throws Exception{
		mockMvc.perform(get("/createuser"))
		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("userform"))
		.andExpect(model().attribute("player", new Player()));
	}
	
	@Test
	public void createPostTest() throws Exception{
		Player expectedUser = new Player(null, "Mike", "mike@mike.com", 45);
		mockMvc.perform(post("/createuser").param("name", "Mike")
				.param("email", "mike@mike.com").param("age", "45"))
		.andExpect(status().isOk())
		.andExpect(view().name("saved"))
		.andExpect(model().attribute("player", expectedUser));
		
		Mockito.verify(playerRepo).save(eq(expectedUser));
	}
	
	@Test
	public void createPostTest_InvalidUser() throws Exception{
		Player expectedUser = new Player(null, "Mike", "mike", 45);
		mockMvc.perform(post("/createuser").param("name", "Mike")
				.param("email", "mike").param("age", "45"))
		.andExpect(status().isOk())
		.andExpect(view().name("userform"))
		.andExpect(model().attribute("player", expectedUser));
		
		Mockito.verifyNoMoreInteractions(playerRepo);
		
	}
	
	@Test
	public void listUserTest() throws Exception{
		List<Player> expectedList = new ArrayList<>();
		expectedList.add(new Player(null, "Mike", "mike@mike.com", 45));
		Mockito.when(playerRepo.findAll()).thenReturn(expectedList);
		mockMvc.perform(get("/allusers"))
		.andExpect(status().isOk())
		.andExpect(view().name("allusers"))
		.andExpect(model().attribute("users", expectedList));
	}
	
	@Test
	public void indexTest() throws Exception{
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("welcome"));
	}
}
