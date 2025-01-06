package com.ruthwik.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ruthwik.dto.DashboardResponse;
import com.ruthwik.entities.Counsellor;
import com.ruthwik.entities.Enquiry;
import com.ruthwik.repo.CounsellorRepo;
import com.ruthwik.repo.EnquiryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounsellorServiceImpl implements CounsellorService {
	private final CounsellorRepo counrepo;
	private final EnquiryRepo enqrepo;
	@Override
	public boolean register(Counsellor counsellor) {
		// TODO Auto-generated method stub
	    Counsellor cons=	counrepo.save(counsellor);
	    if(cons.getCounsellor_id() != null)
	    {
	    	return true;
	    }
		return false;
	}

	@Override
	public Counsellor login(String name, String pwd) {
		// TODO Auto-generated method stub
		Counsellor cons=counrepo.findByEmailAndPwd(name , pwd);
		
		return cons;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		// TODO Auto-generated method stub
		DashboardResponse response=new DashboardResponse();
		List<Enquiry> enqList = enqrepo.getEnquiriesByCounsellorId(counsellorId);
		int total=enqList.size();
		int enrolled= enqList.stream().filter( e -> e.getEnqStatus().equals("Enrolled")).collect(Collectors.toList()).size();
		int lost=enqList.stream().filter( e -> e.getEnqStatus().equals("Lost")).collect(Collectors.toList()).size();
		int open=enqList.stream().filter( e -> e.getEnqStatus().equals("Open")).collect(Collectors.toList()).size();
		response.setEnrolledenq(enrolled);
		response.setLostenq(lost);
		response.setTotalenq(total);
		response.setOpenenq(open);
		
		return response;
	}

	@Override
	public Counsellor findByemail(String email) {
		// TODO Auto-generated method stub
		return counrepo.findByEmail(email);
	}
	

}
