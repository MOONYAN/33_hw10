package course.java.spring.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 */
@Controller
public class AuthController
{
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value = "/iMovie", method = RequestMethod.GET)
	private String operation()
	{
		return "iMovie";
	}

	/**
	 * 
	 */
	@RequestMapping("/loginError")
	public String loginError(ModelMap modelMap)
	{
		modelMap.addAttribute("errorMessage", "Authenticatuon Error!");
		return "index";
	}

	/**
	 * 
	 */
	@RequestMapping("/accessError")
	public String accessError(ModelMap modelMap)
	{
		modelMap.addAttribute("errorMessage", "Authorization Error!");
		return "index";
	}

}