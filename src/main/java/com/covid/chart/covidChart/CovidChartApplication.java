package com.covid.chart.covidChart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.covid.chart.covidChart.Entity.CompleteReceipt;
import com.covid.chart.covidChart.Entity.TotalCount;

@SpringBootApplication
public class CovidChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidChartApplication.class, args);
	}
	
	@Bean
	public TotalCount allVaccineCount() {
		return new TotalCount(0);
	}
	
	@Bean
	public CompleteReceipt receipt() {
		return new CompleteReceipt();
	}
}

