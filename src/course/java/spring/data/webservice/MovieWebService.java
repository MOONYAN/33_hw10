package course.java.spring.data.webservice;

import java.util.List;

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

import course.java.spring.data.filmmodel.FilmMovieModel;

/**
 * 
 */
@RestController
@RequestMapping(value = "/ws/movies")
@Transactional("jpaTransactionManager")
public class MovieWebService
{
	static int STOREID = 33;
	RestTemplate restTemplate = new RestTemplate();
	//String filmApiUrl = "http://iweb.csie.ntut.edu.tw:8080/33_api09/api";
	String filmApiUrl = "http://localhost:8080/33_api09/api";

	/**
	 * @param MovieModel
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody FilmMovieModel createMovie(@RequestBody FilmMovieModel movieModel)
	{
		System.out.println("ws-------------createMovie");
		movieModel.setStoreId(STOREID);
		movieModel = restTemplate.postForObject(filmApiUrl + "/movies", movieModel, FilmMovieModel.class);
		return movieModel;
	}

	/**
	 * @param movieId
	 */
	@RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteMovie(@PathVariable int movieId)
	{
		System.out.println("ws-------------deleteMovie");
		restTemplate.delete(filmApiUrl + "/movies/" + movieId);
	}

	/**
	 * @param movieId
	 */
	@RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
	public @ResponseBody FilmMovieModel getMovie(@PathVariable int movieId)
	{
		System.out.println("ws-------------getMovie");
		FilmMovieModel movieModel = restTemplate.getForObject(filmApiUrl + "/movies/" + movieId, FilmMovieModel.class);
		return movieModel;
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<FilmMovieModel> getMovies()
	{
		System.out.println("ws-------------getMovies");
		@SuppressWarnings("unchecked")
		List<FilmMovieModel> movieModels = restTemplate.getForObject(filmApiUrl + "/movies/", List.class);
		ObjectMapper mapper = new ObjectMapper();
		movieModels = mapper.convertValue(movieModels, new TypeReference<List<FilmMovieModel>>()
		{
		});
		return movieModels;
	}

	@RequestMapping(value = "/store/", method = RequestMethod.GET)
	public @ResponseBody List<FilmMovieModel> getStoreMovies()
	{
		System.out.println("ws-------------getStoreMovies");
		@SuppressWarnings("unchecked")
		List<FilmMovieModel> movieModels = restTemplate.getForObject(filmApiUrl + "/movies/store/" + STOREID,
				List.class);
		ObjectMapper mapper = new ObjectMapper();
		movieModels = mapper.convertValue(movieModels, new TypeReference<List<FilmMovieModel>>()
		{
		});
		return movieModels;
	}
}