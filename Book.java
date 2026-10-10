
public class Book extends MediaItem implements Loanable {

	private String genre;
	private String isbn;
	
	public Book(String itemID, String title, String author, int year, String genre, String isbn)
	{
		super(itemID, title, author, year);
		this.genre = genre;
		this.isbn = isbn;
	}
	
	@Override
	public String getItemDetails() //the book details
	{
		return "BOOK | " + title + " by " + authorOrDirector +
				" (" + publicationYear + ") | Genre: " + genre +
				" | ID: " + itemID + " | ISBN: " + isbn + " | Available: " + isAvailable;
	}
	
	@Override
	public int calculateLateFee(int daysLate)
	{
		return daysLate * 1;  //one dollar a day
	}
}
