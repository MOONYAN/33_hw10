package course.java.spring.data.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import course.java.spring.data.filmmodel.FilmLogModel;
import course.java.spring.data.springdata.UserRepository;

/**
 * 
 */
@RestController
@RequestMapping(value = "/ws/logs")
@Transactional("jpaTransactionManager")
public class LogWebService
{
	@Autowired
	UserRepository userRepository;

	static int STOREID = 33;
	RestTemplate restTemplate = new RestTemplate();
	//String filmApiUrl = "http://iweb.csie.ntut.edu.tw:8080/33_api09/api";
	String filmApiUrl = "http://localhost:8080/33_api09/api";

	@RequestMapping(value = "/booker/", method = RequestMethod.GET)
	public @ResponseBody List<FilmLogModel> getBookerLogs()
	{
		System.out.println("ws-------------getBookerLogs");
		String username = getUserName();
		int bookerId = userRepository.findByUsername(username).getBookerId();
		System.out.println("ws-------------getBookerLogs------bookerid=" + bookerId);
		@SuppressWarnings("unchecked")
		List<FilmLogModel> logModels = restTemplate.getForObject(filmApiUrl + "/logs/booker/" + bookerId+"/", List.class);
		ObjectMapper mapper = new ObjectMapper();
		logModels = mapper.convertValue(logModels, new TypeReference<List<FilmLogModel>>()
		{
		});
		return logModels;
	}

	@RequestMapping(value = "/store/", method = RequestMethod.GET)
	public @ResponseBody List<FilmLogModel> getStoreLogs()
	{
		System.out.println("ws-------------getStoreLogs");
		@SuppressWarnings("unchecked")
		List<FilmLogModel> logModels = restTemplate.getForObject(filmApiUrl + "/logs/store/" + STOREID+"/", List.class);
		ObjectMapper mapper = new ObjectMapper();
		logModels = mapper.convertValue(logModels, new TypeReference<List<FilmLogModel>>()
		{
		});
		return logModels;
	}

	private String getUserName()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}