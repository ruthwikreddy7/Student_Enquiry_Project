package com.ruthwik.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "counsellor_tbl")
public class Counsellor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellor_id;
	private String name;
	@Column(name="email",unique = true)
	
	private String email;
	@Column(name = "pwd")
	private String pwd;
	@CreationTimestamp
	private LocalDate createddate;
	@UpdateTimestamp
	private LocalDate updateddate;

}
