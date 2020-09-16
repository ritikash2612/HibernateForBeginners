package com.riti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "first_name")
	public String fisrtName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "email")
	public String email;

	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String fisrtName, String lastName, String email) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
