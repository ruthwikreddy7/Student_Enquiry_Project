package com.ruthwik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruthwik.entities.Counsellor;
import com.ruthwik.service.CounsellorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CounsellorController {
	private final CounsellorService counservice;
	
	@PostMapping("/login")
	public String login(@RequestBody Counsellor coun)
	{
		Counsellor login= counservice.login(coun.getEmail(), coun.getPwd());
		if(login != null)
		{
			return "Counsellor is sucessfully logged in with id "+login.getCounsellor_id()+" and name : "+login.getName()+" is done...";
		}
		
		return "Counsellor is not registered. please register first...";
		
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Counsellor coun)
	{
		boolean registered = counservice.register(coun);
		if(registered==true)
		{
			return "Registration sucessful with name: "+coun.getName()+" mail :"+coun.getEmail()+" passwd: "+coun.getPwd();
		}
		return "registration failed";
	}
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to api";
	}

}
