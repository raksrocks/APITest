/**
 * 
 */
package com.whitbread.beans;

/**
 * @author Administrator
 *
 */
public class Payload {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String title;
	private String statuCode;
	
	
	public Payload(String email, String password, String firstName, String lastName, String title) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}
	public Payload() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the statuCode
	 */
	public String getStatuCode() {
		return statuCode;
	}
	/**
	 * @param statuCode the statuCode to set
	 */
	public void setStatuCode(String statuCode) {
		this.statuCode = statuCode;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
