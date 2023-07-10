package ca.lambton.termProjectc0839829;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
	public Player findByAge(Integer age);
}
