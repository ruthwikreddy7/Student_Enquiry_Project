package com.ruthwik.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ruthwik.entities.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
	@Query(value = "select * from enquiry_tbl where counsellorId=:CounsellorId", nativeQuery = true)
	public List<Enquiry> getEnquiriesByCounsellorId(Integer CounsellorId);
}
