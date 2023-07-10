package ca.lambton.termProjectc0839829;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {
	@Bean
	public PageCounter getCounter() {
		return new PageCounter();
	}
}
