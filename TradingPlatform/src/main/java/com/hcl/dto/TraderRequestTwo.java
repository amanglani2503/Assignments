package com.hcl.dto;

public class TraderRequestTwo {
	private String email;
	private double balance;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	 public TraderRequestTwo() {
		// TODO Auto-generated constructor stub
	}
	public TraderRequestTwo(String email, double balance) {
		super();
		this.email = email;
		this.balance = balance;
	}

}