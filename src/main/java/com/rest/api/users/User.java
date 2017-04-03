package com.rest.api.users;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The User model class contains all the fields & respective Getter & Setters of the entity User
 * @author Neha Lall
 *
 */

@SuppressWarnings("serial")
@XmlRootElement
public class User implements Serializable{

	private int user_id;
	private String email;
	private String address;
	private String zip_code;
	private String account_status;

	/*Default No Args Constructor*/
	public User(){}
	
	/*Parameterized Constructor of the User class*/	
	public User(int user_id, String email, String address, String zipcode){
		this.user_id = user_id;
		this.email = email;
		this.address = address;
		this.zip_code = zipcode;
	}
	
	/*Getters & Setters	for the class fields*/
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	
}
