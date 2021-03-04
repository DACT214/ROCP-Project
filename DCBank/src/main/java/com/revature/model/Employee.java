package com.revature.model;

public class Employee {
	
	private int emID;
	private String emC;
	private String password;
	private String firstName;
	private String lastName;
	
	public Employee() {
		super();
	}
	
	public Employee(int emID, String emC, String password, String firstName, String lastName) {
		super();
		this.emID = emID;
		this.emC = emC;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getEmID() {
		return emID;
	}

	public void setEmID(int emID) {
		this.emID = emID;
	}

	public String getEmC() {
		return emC;
	}

	public void setEmC(String emC) {
		this.emC = emC;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emC == null) ? 0 : emC.hashCode());
		result = prime * result + emID;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emC == null) {
			if (other.emC != null)
				return false;
		} else if (!emC.equals(other.emC))
			return false;
		if (emID != other.emID)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [emID=" + emID + ", emC=" + emC + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
}