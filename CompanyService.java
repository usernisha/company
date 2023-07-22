package com.example.company;

//CompanyService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CompanyService {
 
 @Autowired
 private CompanyRepository companyRepository;

 public List<Company> getAllCompanies() {
     return companyRepository.findAll();
 }

 public Company getCompanyById(Long id) {
     return companyRepository.findById(id).orElse(null);
 }

 public Company saveCompany(Company company) {
     return companyRepository.save(company);
 }

 public void deleteCompany(Long id) {
     companyRepository.deleteById(id);
 }
 public List<Company> getHighestRentPayingCompanies() {
     return companyRepository.findAllByOrderByRentDesc();
 }

 public List<Company> getTopTwoHighestRentPayingCompanies() {
     return companyRepository.findTop2ByOrderByRentDesc();
 }

 public Company updateCompany(Company company) {
		Company existingCompany = companyRepository.findById(company.getId()).get();
		existingCompany.setCompanyName(company.getCompanyName());
		existingCompany.setPhnnum(company.getPhnnum());
        existingCompany.setRent(company.getRent());
        Company updatedCompany = companyRepository.save(existingCompany);
		return updatedCompany;
	}
	
}
