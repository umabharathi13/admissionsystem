package com.cg.admissionsystem.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int addressId;
	private String city;
	private String district;
	private String state;
	private String country;
	private String zipcode;
	private String landmark;
	
	
	public Address() {}
	public Address(int addressId, String city, String district, String state, String country, String zipcode,
			String landmark) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.landmark = landmark;
		
		
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", country=" + country + ", zipcode=" + zipcode + ", landmark=" + landmark + "]";
	}
	}


