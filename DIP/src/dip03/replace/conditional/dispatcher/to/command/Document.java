package dip03.replace.conditional.dispatcher.to.command;

public class Document {

	private static int nextDocumentCode = 0;
	
	private String title;
	private int code;
	
	protected Document(String title) {
		this.title = title;
		code = nextDocumentCode++;
	}
	
	public String getTitle() {
		return title;
	}

	public int getCode() {
		return code;
	}
	
	// dirty hack
	static void resetNextDocumentCode() {
		nextDocumentCode = 0;
	}

}
