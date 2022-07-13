package com.covid.chart.covidChart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.chart.covidChart.Entity.Hospital;

@Repository
public interface HospitalRepo  extends JpaRepository<Hospital,Integer>{

}
