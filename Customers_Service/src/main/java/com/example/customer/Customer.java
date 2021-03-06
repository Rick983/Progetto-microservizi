package com.example.customer;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public class Customer {
	private @Id @GeneratedValue Long id;
	private String name;
	private String surname;
	private String mail;
	
	
	public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public String getSurname() {
		return surname;
	}

    public void setSurname(String surname) {
		this.surname = surname;
	}

    public String getMail() {
		return mail;
	}

    public void setMail(String mail) {
		this.mail = mail;
	}

    Customer() {}

    public Customer(String name, String surname, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}
}