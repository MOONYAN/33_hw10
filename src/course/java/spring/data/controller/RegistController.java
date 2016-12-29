package course.java.spring.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import course.java.spring.data.model.UserModel;

/**
 * 
 */
@Controller
public class RegistController
{
	RestTemplate restTemplate = new RestTemplate();
	String userWSUrl = "http://localhost:8080/33_homework09/ws/users";

	/**
	 * 
	 */
	@RequestMapping("/regist")
	public String regist(UserModel userModel, ModelMap modelMap)
	{
		System.out.println("controller-------------regist");
		if (userModel.getUsername() == "")
		{
			modelMap.addAttribute("errorMessage", "Input Error");
			return "index";
		}
		userModel.setRole("customer");
		userModel = restTemplate.postForObject(userWSUrl, userModel, UserModel.class);
		if (userModel == null)
		{
			modelMap.addAttribute("errorMessage", "The member has been existed!");
		}
		else
		{
			modelMap.addAttribute("userModel", userModel);
			modelMap.addAttribute("message", "regist success");
		}
		return "index";
	}
}