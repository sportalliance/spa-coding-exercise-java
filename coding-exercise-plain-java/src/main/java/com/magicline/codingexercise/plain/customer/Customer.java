package com.magicline.codingexercise.plain.customer;

public class Customer {

	private long id;

	public Customer(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				'}';
	}
}
