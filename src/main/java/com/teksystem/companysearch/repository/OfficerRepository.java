package com.teksystem.companysearch.repository;

import com.teksystem.companysearch.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OfficerRepository extends JpaRepository<Officer, Long> {
}
