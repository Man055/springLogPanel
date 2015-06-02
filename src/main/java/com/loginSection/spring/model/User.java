package com.loginSection.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserID;
	@Column(name = "FirstName", nullable = false)
	private String FirstName;
	@Column(name = "LastName", nullable = false)
	private String LastName;
	@Column(name = "Email", nullable = false)
	private String Email;
	
	
	public int getUserID() {
        return UserID;
    }
 
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
	public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName){
		this.LastName = LastName;
	}
	
	public void setEmail(String Email){
		this.Email = Email;
	}
	
	public String getFirstName(){
		return FirstName;
	}
	
	public String getLastName(){
		return LastName;
	}
	
	public String getEmail(){
		return Email;
	}
	
}
