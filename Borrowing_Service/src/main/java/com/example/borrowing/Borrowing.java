package com.example.borrowing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public class Borrowing {
	private @Id @GeneratedValue Long id;
	private int bookID;
	private int customerID;
	private String dateStart;
	private String dateEnd;
	
	
    public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	Borrowing() {}
	public Borrowing(int bookID, int customerID, String dateStart, String dateEnd) {
		super();
		this.bookID = bookID;
		this.customerID = customerID;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	

}
