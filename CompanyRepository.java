package com.example.company;

import java.util.List;

//CompanyRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findAllByOrderByRentDesc();
 // Add custom queries if needed

	List<Company> findTop2ByOrderByRentDesc();
}
