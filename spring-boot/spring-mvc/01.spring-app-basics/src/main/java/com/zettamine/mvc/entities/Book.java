package com.zettamine.mvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer bookId;
	private String bookName;
	private Float bookPrice;
	private String bookAuthor;
	

}
