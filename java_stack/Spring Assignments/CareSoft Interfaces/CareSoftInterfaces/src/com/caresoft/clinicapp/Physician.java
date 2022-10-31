package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes=new  ArrayList<String>() ;
	
    public Physician(Integer id) {
    	this.id = id;
    }
    
    // TO DO: Implement HIPAACompliantUser!
	public  boolean assignPin(int pin) {
		if (pin > 999 && pin < 9999){
			this.pin = pin;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean accessAuthorized(Integer id) {
		if(this.id==id) {
			return true;
		}
		else {
			return false;
		}
	}
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters


}
