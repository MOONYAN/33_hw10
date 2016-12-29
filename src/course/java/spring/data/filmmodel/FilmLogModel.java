package course.java.spring.data.filmmodel;

import java.util.*;

/**
 * 
 */
public class FilmLogModel
{

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
	private String type;

	/**
	 * 
	 */
	private String movieName;

	/**
	 * 
	 */
	private int ticketId;

	/**
	 * 
	 */
	private Date timeStamp;

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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getMovieName()
	{
		return movieName;
	}

	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}

	public int getTicketId()
	{
		return ticketId;
	}

	public void setTicketId(int ticketId)
	{
		this.ticketId = ticketId;
	}

	public Date getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	

}