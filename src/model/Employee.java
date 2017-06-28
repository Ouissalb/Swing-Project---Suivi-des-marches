/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author boughriba
 */
public class Employee {
	
	private String empNom;
	private String empPrenom;
	private String empUsername;
	private String empPassword;
	private String service;
        
	public String getempNom() {
		return empNom;
	}
	public String getempPrenom() {
		return empPrenom;
	}
	public String getempUsername() {
		return empUsername;
	}
	public String getempPassword() {
		return empPassword;
	}
	public void setempNom(String empNom) {
		this.empNom = empNom;
	}
	public void setempPrenom(String empPrenom) {
		this.empPrenom = empPrenom;
	}
	public void setempUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	public void setempPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	@Override
	public String toString() {
		return "Details de l'employé : Nom =" + empNom + ", Prenom=" + empPrenom + ", Username ="
				+ empUsername + ", encrypted password =" + empPassword;
	}	
		
}