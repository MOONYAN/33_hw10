package course.java.spring.data.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import course.java.spring.data.entity.User;
import course.java.spring.data.model.UserModel;
import course.java.spring.data.springdata.UserRepository;

/**
 * 
 */
@RestController
@RequestMapping(value = "/ws/users")
@Transactional("jpaTransactionManager")
public class UserWebService
{
	@Autowired
	UserRepository userRepository;

	static int STOREID = 33;
	RestTemplate restTemplate = new RestTemplate();
	//String filmApiUrl = "http://iweb.csie.ntut.edu.tw:8080/33_api09/api";
	String filmApiUrl = "http://localhost:8080/33_api09/api";

	/**
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<UserModel> getUsers()
	{
		System.out.println("ws-------------getUsers");
		List<UserModel> userModels = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for (User user : users)
		{
			userModels.add(convertToModel(user));
		}
		return userModels;
	}

	/**
	 * @param userModel
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody UserModel createUser(@RequestBody UserModel userModel)
	{
		System.out.println("ws-------------createUser");
		if (userRepository.findByUsername(userModel.getUsername()) == null)
		{
			User user = new User();
			user.setUsername(userModel.getUsername());
			user.setPassword(userModel.getPassword());
			user.setRole(userModel.getRole());
			System.out.println("role " + userModel.getRole());
			if (userModel.getRole().equals("customer"))
			{
				System.out.println("role " + userModel.getRole());
				int bookerId = restTemplate.postForObject(filmApiUrl + "/bookers", STOREID, int.class);
				user.setBookerId(bookerId);
			}
			userRepository.save(user);
			userModel.setId(user.getId());
			return userModel;
		}
		return null;
	}

	/**
	 * @param userId
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable int userId)
	{
		System.out.println("ws-------------deleteUser");
		if (userRepository.exists(userId))
		{
			int bookerId = userRepository.findOne(userId).getBookerId();
			restTemplate.delete(filmApiUrl + "/bookers/" + bookerId, bookerId);
			userRepository.delete(userId);
		}
	}

	private UserModel convertToModel(User user)
	{
		UserModel userModel = new UserModel();
		userModel.setId(user.getId());
		userModel.setUsername(user.getUsername());
		userModel.setPassword(user.getPassword());
		userModel.setRole(user.getRole());
		return userModel;
	}
}