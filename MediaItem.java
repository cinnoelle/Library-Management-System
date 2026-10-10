
public abstract class MediaItem {
	protected String itemID;
	protected String title;
	protected String authorOrDirector;
	protected int publicationYear;
	protected boolean isAvailable;
	
	public MediaItem(String itemID, String title, String authorOrDirector, int publicationYear)
	{
		this.itemID = itemID;
		this.title = title;
		this.authorOrDirector = authorOrDirector;
		this.publicationYear = publicationYear;
		this.isAvailable = true;
	}
	
	public abstract String getItemDetails();

	public void checkOut()
	{
		if(isAvailable)
		{
			isAvailable = false;
			System.out.println(title + " has been checked out.");
		}
		else
		{
			System.out.println(title + " is already checked out.");
		}
	}
	
	public void returnItem()
	{
		if(!isAvailable)
		{
			isAvailable = true;
			System.out.println(title + " has been returned.");
		}
		else
		{
			System.out.println(title + " was not checked out.");
		}
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getItemID()
	{
		return itemID;
	}
	public int getPublicationYear()
	{
		return publicationYear;
	}
	public boolean isAvailable()
	{
		return isAvailable;
	}
}
