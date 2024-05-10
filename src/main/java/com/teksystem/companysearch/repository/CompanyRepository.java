package com.teksystem.companysearch.repository;

import com.teksystem.companysearch.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
