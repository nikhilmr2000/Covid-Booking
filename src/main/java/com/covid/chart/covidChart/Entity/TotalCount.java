package com.covid.chart.covidChart.Entity;


public class TotalCount {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TotalCount(int count) {
		super();
		this.count = count;
	}

	public TotalCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TotalCount [count=" + count + "]";
	}
	
}
