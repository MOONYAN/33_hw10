package course.java.spring.data.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import course.java.spring.data.filmmodel.FilmBookingModel;
import course.java.spring.data.filmmodel.FilmTicketModel;
import course.java.spring.data.springdata.UserRepository;

/**
 * 
 */
@RestController
@RequestMapping(value = "/ws/tickets")
@Transactional("jpaTransactionManager")
public class TicketWebService
{

	@Autowired
	UserRepository userRepository;

	static int STOREID = 33;
	RestTemplate restTemplate = new RestTemplate();
	//String filmApiUrl = "http://iweb.csie.ntut.edu.tw:8080/33_api09/api";
	String filmApiUrl = "http://localhost:8080/33_api09/api";

	/**
	 * @param TicketModel
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody FilmTicketModel bookTicket(@RequestBody FilmBookingModel bookingModel)
	{
		System.out.println("ws-------------bookTicket");
		String username = getUserName();
		int bookerId = userRepository.findByUsername(username).getBookerId();
		System.out.println("ws-------------bookTicket------bookerid=" + bookerId);
		bookingModel.setBookerId(bookerId);

		FilmTicketModel ticketModel = restTemplate.postForObject(filmApiUrl + "/tickets", bookingModel,
				FilmTicketModel.class);
		return ticketModel;
	}

	/**
	 * @param ticketId
	 */
	@RequestMapping(value = "/{ticketId}", method = RequestMethod.DELETE)
	public @ResponseBody void cancelTicket(@PathVariable int ticketId)
	{
		System.out.println("ws-------------cancelTicket");
		restTemplate.delete(filmApiUrl + "/tickets/" + ticketId);
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/booker/", method = RequestMethod.GET)
	public @ResponseBody List<FilmTicketModel> getBookerTickets()
	{
		System.out.println("ws-------------getBookerTickets");
		String username = getUserName();
		int bookerId = userRepository.findByUsername(username).getBookerId();
		System.out.println("ws-------------getBookerTickets------bookerId=" + bookerId);
		@SuppressWarnings("unchecked")
		List<FilmTicketModel> ticketModels = restTemplate.getForObject(filmApiUrl + "/tickets/booker/" + bookerId + "/",
				List.class);
		ObjectMapper mapper = new ObjectMapper();
		ticketModels = mapper.convertValue(ticketModels, new TypeReference<List<FilmTicketModel>>()
		{
		});
		/*for (FilmTicketModel filmTicketModel : ticketModels)
		{
			System.out.println("ws--------getBookerTickets----getBookerId" + filmTicketModel.getBookerId());
			System.out.println("ws--------getBookerTickets----getMovieName" + filmTicketModel.getMovieName());
			System.out.println("ws--------getBookerTickets----getShowTime" + filmTicketModel.getShowTime());
			System.out.println("ws--------getBookerTickets----getSeat" + filmTicketModel.getSeat());
		}*/
		return ticketModels;
	}

	@RequestMapping(value = "/store/", method = RequestMethod.GET)
	public @ResponseBody List<FilmTicketModel> getStoreTickets()
	{
		System.out.println("ws-------------getStoreTickets");
		@SuppressWarnings("unchecked")
		List<FilmTicketModel> ticketModels = restTemplate.getForObject(filmApiUrl + "/tickets/store/" + STOREID + "/",
				List.class);
		ObjectMapper mapper = new ObjectMapper();
		ticketModels = mapper.convertValue(ticketModels, new TypeReference<List<FilmTicketModel>>()
		{
		});
		return ticketModels;
	}

	private String getUserName()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}