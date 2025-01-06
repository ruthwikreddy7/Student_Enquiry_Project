package com.ruthwik.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruthwik.entities.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	public Counsellor findByEmail(String email);
	public Counsellor findByEmailAndPwd(String email,String pwd);

}
