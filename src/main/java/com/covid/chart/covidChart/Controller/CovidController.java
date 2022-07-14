package com.covid.chart.covidChart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.covid.chart.covidChart.Entity.CompleteReceipt;
import com.covid.chart.covidChart.Entity.Details;
import com.covid.chart.covidChart.Entity.Hospital;
import com.covid.chart.covidChart.Entity.Patient;
import com.covid.chart.covidChart.Service.CovidService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CovidController {
	 
	@Autowired
	private CovidService covidService;
	
	
	@PostMapping("/hospital")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		if(hospital==null) {
			return new Hospital();
		}
		else {
			Hospital newHospital=covidService.saveHospital(hospital);
			return newHospital;
		}
	}
	
	@PostMapping("/patient")
	public Patient addPatient(@RequestBody Patient patient) {
		if(patient==null) {
			return new Patient();
		}
		else {
			if(covidService.checkVaccine(patient)>0) {
				covidService.SetVaccineAvailability(patient);
				Patient newPatient=covidService.savePatient(patient);
				return newPatient;
			}
			else {
				return new Patient();
			}
		}
	}
	
	@GetMapping("/getHospital")
	public List<Hospital> getHospitals(){
		return covidService.getAllHospitals();
	}
	
	//Patient Details
	@GetMapping("/getPatient")
	public List<Patient> getPatient(){
		return covidService.getPatients();
	}
	
	
	//Balance Vaccines
	
	@GetMapping("/balanceVaccines")
	public int totalVaccines() {
		return covidService.allVaccines();
	}
	
	//Total Vaccines
	
	@GetMapping("/totalVaccines")
	public int allVaccines() {
		return covidService.allVaccinesCount();
	}
	
	//Booked Vaccines
	
	@GetMapping("/bookedVaccines")
	public int bookedVaccines() {
		int balance=covidService.allVaccines();
		int total=covidService.allVaccinesCount();
		int bookedVaccines=total-balance;
		return bookedVaccines;
	}
	
	//Hospital List
	
	@GetMapping("/hospitalNames")
	public List<String> getHospNames(){
		return covidService.getHospitals();
	}
	
	//Particular Hospital Vaccine Availability
	
	@GetMapping("/hospital/{hospName}")
	public int availableVaccine(@PathVariable String hospName) {
		return covidService.availableVaccine(hospName);
	}
	
	@PostMapping("/getDetails")
	public CompleteReceipt allReceipt(@RequestBody Details details) {
		return covidService.getDetails(details);
	}
	
	@GetMapping("/allDetails")
	public CompleteReceipt totalDetails() {
		return covidService.details();
	}
	
}
