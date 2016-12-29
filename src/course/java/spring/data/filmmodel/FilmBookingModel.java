package course.java.spring.data.filmmodel;

public class FilmBookingModel
{
	private int bookerId;
	private int movieId;
	private String seat;
	private String showTime;
	
	public int getBookerId()
	{
		return bookerId;
	}
	public void setBookerId(int bookerId)
	{
		this.bookerId = bookerId;
	}
	public int getMovieId()
	{
		return movieId;
	}
	public void setMovieId(int movieId)
	{
		this.movieId = movieId;
	}
	public String getSeat()
	{
		return seat;
	}
	public void setSeat(String seat)
	{
		this.seat = seat;
	}
	public String getShowTime()
	{
		return showTime;
	}
	public void setShowTime(String showTime)
	{
		this.showTime = showTime;
	}
	
	
}
