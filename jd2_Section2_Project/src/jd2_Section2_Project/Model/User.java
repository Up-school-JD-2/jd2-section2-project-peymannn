package jd2_Section2_Project.Model;

import java.util.Objects;

public class User extends Data {
	private String surname;
	private String phoneNumber;
	private String email;	

	@Override
	public int hashCode() {
		return Objects.hash(getId(),getName(),email, phoneNumber, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(getId(), other.getId()) && Objects.equals(getName(), other.getName()) && Objects.equals(email, other.email) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(surname, other.surname);
	}

	public User(String id, String name, String surname, String phoneNumber, String email) {
		super(name, id);
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}	

	@Override
	public String toString() {
		return "User [Id=" + getId() + ", phoneNumber=" + phoneNumber + ", email=" + email + ", getName()="
				+ getName() + ", surname=" + surname + "]";
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
