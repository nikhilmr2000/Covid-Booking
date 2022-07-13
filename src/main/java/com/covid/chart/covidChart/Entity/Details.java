package com.covid.chart.covidChart.Entity;


public class Details {
	
	private long unique;
	private String name;
	
	public long getUnique() {
		return unique;
	}
	public void setUnique(long unique) {
		this.unique = unique;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(long unique, String name) {
		super();
		this.unique = unique;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Details [unique=" + unique + ", name=" + name + "]";
	}
	
	
	
}
