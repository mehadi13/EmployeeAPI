package com.bjit.training.employee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nationalities database table.
 * 
 */
@Entity
@Table(name="nationalities")
@NamedQuery(name="Nationality.findAll", query="SELECT n FROM Nationality n")
public class Nationality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String country;


	public Nationality() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}