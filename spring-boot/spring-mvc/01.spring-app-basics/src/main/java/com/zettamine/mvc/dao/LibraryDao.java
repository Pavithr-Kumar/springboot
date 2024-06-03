package com.zettamine.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import com.zettamine.mvc.entities.Book;

@Repository
public class LibraryDao {
	List<Book> books;

	public List<Book> getAll(){
		books = new ArrayList<>();
		books.add(new Book(101, "Java Complete Reference", 2000f, "Punya Koti"));
		books.add(new Book(102, "React JS ", 1500f, "Hari Nath"));
		books.add(new Book(103, "Node JS Tutorial", 1700f, "Jagadesh"));
		books.add(new Book(104, "Spring Boot Complete", 1000f, "Bharath"));
		books.add(new Book(105, "Angular JS", 2500f, "Akash"));
		return books;
	}
	
	public List<Book> deleteBook(Integer id) {
		ListIterator<Book> booksItr = books.listIterator();
		while(booksItr.hasNext()) {
			if(booksItr.next().getBookId()==id) {
				booksItr.remove();
			}
		}
		return books;
	}
}
