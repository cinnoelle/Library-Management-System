
public class DVD extends MediaItem implements Loanable {

	private int duration;
	private String rating;
	
	public DVD(String itemID, String title, String director, int year, int duration, String rating)
	{
		super(itemID, title, director, year);
		this.duration = duration;
		this.rating = rating;
	}
	
	@Override
	public String getItemDetails() //DVD info
	{
		return "DVD | " + title + " directed by " + authorOrDirector +
				" (" + publicationYear + ") | Duration: " + duration +
				" min | Rating: " + rating + " | ID: " + itemID + " | Available: " + isAvailable;
	}
	
	@Override
	public int calculateLateFee(int daysLate) {
		return daysLate * 2; //two dollars a day
	}
}
