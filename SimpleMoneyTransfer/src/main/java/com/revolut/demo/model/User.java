/**
 * 
 */
package com.revolut.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * A user of the bank
 * 
 * @author geovanefilho
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = false)
	private Account account;
	
	protected User() {
		super();
	}

	public User(String name, String username, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		account.setUser(this);
		this.account = account;
	}

}
