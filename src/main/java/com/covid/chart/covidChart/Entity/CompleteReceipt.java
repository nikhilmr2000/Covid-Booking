package com.covid.chart.covidChart.Entity;

public class CompleteReceipt {
	
	private long uniqueid;
	private String name;
	private String hospital;
	private String vaccines;
	
	public long getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(long uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getVaccines() {
		return vaccines;
	}
	public void setVaccines(String vaccines) {
		this.vaccines = vaccines;
	}
	public CompleteReceipt(long uniqueid, String name, String hospital, String vaccines) {
		super();
		this.uniqueid = uniqueid;
		this.name = name;
		this.hospital = hospital;
		this.vaccines = vaccines;
	}
	public CompleteReceipt() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CompleteReceipt [uniqueid=" + uniqueid + ", name=" + name + ", hospital=" + hospital + ", vaccines="
				+ vaccines + "]";
	}
	
}
