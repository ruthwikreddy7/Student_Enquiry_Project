package com.ruthwik.service;

import com.ruthwik.dto.DashboardResponse;
import com.ruthwik.entities.Counsellor;

public interface CounsellorService {
	public Counsellor findByemail(String email);
	public boolean register(Counsellor counsellor);
	public Counsellor login(String name, String pwd);
	public DashboardResponse getDashboardInfo(Integer counsellorId);

}
