package com.hql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_TBL")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	private Integer bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "BOOK_PRICE")
	private Double bookPrice;

	@Column(name = "AUTHOR_ID")
	private Integer authorId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + ", authorId=" + authorId + "]";
	}

}
