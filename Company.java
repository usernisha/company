package com.example.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Company")
public class Company {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String companyName;
 private double rent;
 private String phnnum;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public double getRent() {
	return rent;
}
public void setRent(double rent) {
	this.rent = rent;
}
public String getPhnnum() {
	return phnnum;
}
public void setPhnnum(String phnnum) {
	this.phnnum = phnnum;
}

}
