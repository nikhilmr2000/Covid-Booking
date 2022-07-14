package com.covid.chart.covidChart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.chart.covidChart.Entity.CompleteReceipt;
import com.covid.chart.covidChart.Entity.Details;
import com.covid.chart.covidChart.Entity.Hospital;
import com.covid.chart.covidChart.Entity.Patient;
import com.covid.chart.covidChart.Entity.TotalCount;
import com.covid.chart.covidChart.Repository.CountRepo;
import com.covid.chart.covidChart.Repository.HospitalRepo;
import com.covid.chart.covidChart.Repository.PatientRepo;

@Service
public class CovidService {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private CountRepo countRepo; 
	
	@Autowired
	private CompleteReceipt allDetails;
	
	private int number; 
	
	//Save New Hospital
	
	public Hospital saveHospital(Hospital hospital) {
		TotalCount count=new TotalCount();
		if(hospital==null) {
			return new Hospital();
		}
		else {
			count.setCount(hospital.getVaccineNumber());
			countRepo.save(count);
			Hospital newHospital=hospitalRepo.save(hospital);
			return newHospital;
		}
	}
	
	//Save New Patient
	
	public Patient savePatient(Patient patient) {
		if(patient==null) {
			return new Patient();
		}
		else {
			int max=0;
			List<Patient> pat=patientRepo.findAll();
			for(Patient patients:pat) {
				if(patients.getId()>max) {
					max=patients.getId();
				}
			}
			long unique=2221450+(max+1);
			patient.setUniqueId(unique);
			Patient newPatient=patientRepo.save(patient);
			return newPatient;
		}
	}
	
	//Get All Hospital Details
	
	public List<Hospital> getAllHospitals(){
		return hospitalRepo.findAll();
	}
		
	//Set Vaccine Availability in hospital
	
	public void SetVaccineAvailability(Patient patient) {
		List<Hospital> allHospitals=hospitalRepo.findAll();
		int number=0;
		for(Hospital hospital :allHospitals) {
			if(hospital.getId()==patient.getHospital().getId()) {
				number=hospital.getVaccineNumber();
				number--;
				hospital.setVaccineNumber(number);
			}
		}
		
	}
	
	//Check Vaccine Avaialable
	
	public int checkVaccine(Patient patient) {
		List<Hospital> allHospitals=hospitalRepo.findAll();
		int number=0;
		for(Hospital hospital :allHospitals) {
			if(hospital.getId()==patient.getHospital().getId()) {
				number=hospital.getVaccineNumber();
			}
		}
		return number;
	}
	
	//Remaining Vaccines Available
	
	public int allVaccines() {
		List<Hospital> allHospitals=hospitalRepo.findAll();
		int total=0;
		for(Hospital hospital:allHospitals) {
			total+=hospital.getVaccineNumber();
		}
		return total;
	}
	
	
	
	//Total Vaccines
	public int allVaccinesCount() {
		int number=0;
		List<TotalCount> count=countRepo.findAll();
		for(TotalCount total:count) {
			number+=total.getCount();
		}
		return number;
	}
	
	//Particular Hospital Vaccines Available
	
	public int availableVaccine(String hospital) {
		int number=0;
		List<Hospital> hospitals=hospitalRepo.findAll();
		for(Hospital hosp: hospitals) {
			if(hosp.getName().equals(hospital)) {
				number=hosp.getVaccineNumber();
			}
		}
		return number;
	}
	
	//Hospital Names List
	
	public List<String> getHospitals(){
		List<String> hospitalNames=new ArrayList<>();
		List<Hospital> hospitals=hospitalRepo.findAll();
		for(Hospital hosp : hospitals) {
			hospitalNames.add(hosp.getName());
		}
		
		return hospitalNames;
	}
	
	//Get Patient Details
	
	public List<Patient> getPatients(){
		return patientRepo.findAll();
	}
	
	//Get Particular Patient Details
	
	public CompleteReceipt getDetails(Details details) {
		List<Patient> patients=patientRepo.findAll();
		for(Patient patient : patients) {
			if(patient.getName().equals(details.getName()) && patient.getUniqueId()==details.getUnique()) {
				allDetails.setName(patient.getName());
				allDetails.setVaccines(patient.getHospital().getVaccines());
				allDetails.setHospital(patient.getHospital().getName());
				allDetails.setUniqueid(patient.getUniqueId());
			}
		}
		return allDetails;
	}
	
	public CompleteReceipt details() {
		return allDetails;
	}
	
}
