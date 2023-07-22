package com.example.company.rest;

import java.util.List;

//CompanyController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.company.Company;
import com.example.company.CompanyService;

@RestController

public class CompanyController {
 private final CompanyService companyService;

 @Autowired
 public CompanyController(CompanyService companyService) {
     this.companyService = companyService;
 }

 @GetMapping("/company")
 public ResponseEntity<Iterable<Company>> getAllCompanies() {
     return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
 }

 @GetMapping("/service")
 public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
     Company company = companyService.getCompanyById(id);
     if (company != null) {
         return new ResponseEntity<>(company, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping("/company")
 public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
     return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
 }

 @DeleteMapping("/company/{id}")
 public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
     companyService.deleteCompany(id);
     return new ResponseEntity<>("deleted",HttpStatus.OK);
 }
 
 @GetMapping("/highest-rent-paying")
 public ResponseEntity<List<Company>> getHighestRentPayingCompanies() {
     List<Company> highestRentPayingCompanies = companyService.getHighestRentPayingCompanies();
     return new ResponseEntity<>(highestRentPayingCompanies, HttpStatus.OK);
 }

 @GetMapping("/top-two-highest-rent-paying")
 public ResponseEntity<List<Company>> getTopTwoHighestRentPayingCompanies() {
     List<Company> topTwoHighestRentPayingCompanies = companyService.getTopTwoHighestRentPayingCompanies();
     return new ResponseEntity<>(topTwoHighestRentPayingCompanies, HttpStatus.OK);
 }
 @PutMapping("/companies/{id}")
 public ResponseEntity<Company> updateCompany(@PathVariable("id") Long companyId,
                                        @RequestBody Company company){
		company.setId(companyId);
		Company updatedCompany = companyService.updateCompany(company);
		return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
     
     }
 }
 
