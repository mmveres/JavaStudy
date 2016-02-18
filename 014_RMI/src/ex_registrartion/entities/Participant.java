package ex_registrartion.entities;

import java.io.Serializable;

public class Participant implements Serializable{
	private String firstName;
	private String lastName;	
	private String organization;
	private String reportTheme;
	private String email;
	
	public Participant() {
	}

	public Participant(String firstName, String lastName, String organization, String reportTheme, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.organization = organization;
		this.reportTheme = reportTheme;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getReportTheme() {
		return reportTheme;
	}

	public void setReportTheme(String reportTheme) {
		this.reportTheme = reportTheme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Participant [firstName=" + firstName + ", lastName=" + lastName + ", organization=" + organization
				+ ", reportTheme=" + reportTheme + ", email=" + email + "]";
	}
	
	
	
	
}
