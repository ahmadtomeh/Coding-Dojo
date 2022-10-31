package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents=new ArrayList<String>();
    
    public  boolean assignPin(int pin) {
		if (pin > 99999){
			this.pin = pin;
			return true;
		}
		else {
			return false;
		}
	}
    
   public ArrayList<String> reportSecurityIncidents(){
    	return securityIncidents;
    }
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
   public AdminUser(Integer id ,String role) {
	   this.id=id;
	   this.role=role;
   }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public  void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    public boolean accessAuthorized(Integer id) {
		if(this.id==id) {
			return true;
		}
		else {
			this.authIncident();
			return false;
			
			
		}
	}
    // TO DO: Setters & Getters

}
