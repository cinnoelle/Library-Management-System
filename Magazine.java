
public class Magazine extends MediaItem implements Loanable {

	private int issueNumber;
	private String month;
	
	public Magazine(String itemID, String title, String editor, int year, int issueNumber, String month)
	{
		super(itemID, title, editor, year);
		this.issueNumber = issueNumber;
		this.month = month;
	}
	
	@Override
	public String getItemDetails()
	{
		return "MAGAZINE | " + title + " edited by " + authorOrDirector + 
				" (" + publicationYear + ") | Issue: " + issueNumber +
				" | Month: " + month + " | ID: " + itemID + " | Available: " + isAvailable;
	}
	
	@Override
	public int calculateLateFee(int daysLate)
	{
		return daysLate * 2; //2 dollars a day
	}
}
