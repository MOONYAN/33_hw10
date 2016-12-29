package course.java.spring.data.filmmodel;

/**
 * 
 */
public class FilmTicketModel {


    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private int bookerId;

	/**
     * 
     */
    private String movieName;

    /**
     * 
     */
    private String showTime;

    /**
     * 
     */
    private String seat;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getBookerId()
	{
		return bookerId;
	}

	public void setBookerId(int bookerId)
	{
		this.bookerId = bookerId;
	}

	public String getMovieName()
	{
		return movieName;
	}

	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}

	public String getShowTime()
	{
		return showTime;
	}

	public void setShowTime(String showTime)
	{
		this.showTime = showTime;
	}

	public String getSeat()
	{
		return seat;
	}

	public void setSeat(String seat)
	{
		this.seat = seat;
	}

    
}