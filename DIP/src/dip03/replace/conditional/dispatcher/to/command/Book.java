package dip03.replace.conditional.dispatcher.to.command;

public class Book extends Document {

	private String author;
	private String ISBN;
	
	public Book(String title, String author, String iSBN) {
		super(title);
		this.author = author;
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

}
