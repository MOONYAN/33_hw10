package course.java.spring.data.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import course.java.spring.data.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "Select * from [USER] where USERNAME = ?1", nativeQuery=true)
	public User findByUsername(String username);
	
	@Query(value = "Select * from [USER] where BOOKER_ID = ?1", nativeQuery=true)
	public User findByCustomerId(int customerId);
	
	@Query(value = "Select * from [USER] where ROLE != ?1", nativeQuery=true)
	public List<User> findByNotRole(String role);
	
	public List<User> findAll();
}