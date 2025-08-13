package com.hcl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="traders")

public class Trader {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   
    private String name;
    @Column(name="email_Add", unique= true, nullable = false)
    private String email;
    private double balance;
//    private LocalDate  createdAt;
//    private LocalDate updatedAt;
    
    private String  createdAt;
    private String updatedAt;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Trader(Long id, String name, String email, double balance, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Trader() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
	
    
}