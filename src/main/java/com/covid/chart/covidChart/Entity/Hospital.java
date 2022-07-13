package com.covid.chart.covidChart.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="hospital")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Hospital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="vaccines")
	private String vaccines;
	
	@Column(name="vaccineNumber")
	private int vaccineNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="hospital",cascade=CascadeType.ALL)
	private List<Patient> patient= new ArrayList<>();
	
	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVaccines() {
		return vaccines;
	}

	public void setVaccines(String vaccines) {
		this.vaccines = vaccines;
	}

	public int getVaccineNumber() {
		return vaccineNumber;
	}

	public void setVaccineNumber(int vaccineNumber) {
		this.vaccineNumber = vaccineNumber;
	}

	public Hospital(long id, String name, String vaccines, int vaccineNumber) {
		super();
		this.id = id;
		this.name = name;
		this.vaccines = vaccines;
		this.vaccineNumber = vaccineNumber;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", vaccines=" + vaccines + ", vaccineNumber=" + vaccineNumber
				+ "]";
	}
	
	
	
}
