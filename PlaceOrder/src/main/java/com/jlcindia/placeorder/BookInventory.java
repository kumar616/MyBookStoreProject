package com.jlcindia.placeorder;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="mybookinventory",schema="jlcordersdb")
@ApiModel("BookInventory contains Inventory details")
public class BookInventory {

	@Id
	@Column(name="book_id")
	private Integer bookId;
	
	@Column(name="books_available")
	private int booksAvailable;
	
	public BookInventory() {}
	
	public BookInventory(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	public BookInventory(Integer bookId, int booksAvailable) {
		super();
		this.bookId = bookId;
		this.booksAvailable = booksAvailable;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getBooksAvailable() {
		return booksAvailable;
	}

	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}
	
	
	
}
