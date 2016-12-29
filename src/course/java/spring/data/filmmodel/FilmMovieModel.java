package course.java.spring.data.filmmodel;

/**
 * 
 */
public class FilmMovieModel
{

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String image;

	/**
	 * 
	 */
	private String video;
	
	/**
	 * 
	 */
	private int storeId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getVideo()
	{
		return video;
	}

	public void setVideo(String video)
	{
		this.video = video;
	}

	public int getStoreId()
	{
		return storeId;
	}

	public void setStoreId(int storeId)
	{
		this.storeId = storeId;
	}
}