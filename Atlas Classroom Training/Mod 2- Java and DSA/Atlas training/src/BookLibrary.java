public class BookLibrary 
{
	String bookName;
	String bookAuthor;
	double bookRating;
	int bookPrice;
	
	public BookLibrary(String bookName, String bookAuthor, double bookRating, int bookPrice)
	{
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookRating = bookRating;
		this.bookPrice = bookPrice;
	}

	public void bookDisplay ()
	{
		System.out.println("Book list");
		System.out.println("------------");
		System.out.println("BOOK NAME : "+ bookName);
		System.out.println("Book Details:");
		System.out.println("Book Rating:"+bookRating+"\t book price:"+bookPrice);
		System.out.println("Book Author:"+bookAuthor);
		System.out.println();
	}
}