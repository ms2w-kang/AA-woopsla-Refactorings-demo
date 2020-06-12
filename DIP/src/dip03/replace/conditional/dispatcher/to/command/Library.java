package dip03.replace.conditional.dispatcher.to.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {

	private List<User> users = new ArrayList<>();
	private List<Document> documents = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}

	public int getUserCount() {
		return users.size();
	}
	
	public void addDocument(Document document) {
		documents.add(document);
	}
	
	public int getDocumentCount() {
		return documents.size();
	}
	
	public List<User> findUsersByName(String name) {
		return users.stream()
				    .filter(u -> name.equals(u.getName()))
				    .collect(Collectors.toList());		   
	}
	
	public Optional<Document> findDocumentByCode(int code) {
		return documents.stream()
				    		.filter(d -> d.getCode() == code)
				    		.findAny();
	}
}
