package com.ruthwik.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ruthwik.dto.ViewRespFilter;
import com.ruthwik.entities.Counsellor;
import com.ruthwik.entities.Enquiry;
import com.ruthwik.repo.CounsellorRepo;
import com.ruthwik.repo.EnquiryRepo;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {
	private final EnquiryRepo enqrepo;
	private final CounsellorRepo conrepo;
	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorid) throws Exception {
		// TODO Auto-generated method stub
		Counsellor counsellor = conrepo.findById(counsellorid).orElse(null);
		if(counsellor == null)
		{
			throw new Exception("no counsellor found..");
		}
		enq.setCounsellor(counsellor);
		Enquiry saved = enqrepo.save(enq);
		if(saved.getEnqId() != null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public List<Enquiry> getAllEnq(Integer counsellorid) {
		// TODO Auto-generated method stub
		return enqrepo.getEnquiriesByCounsellorId(counsellorid);
		
	}

//	@Override
//	public List<Enquiry> getEnqwithfilter(ViewRespFilter viewfilter, Integer counsellorid) {
//		Enquiry enq=new Enquiry();
//		if(StringUtils.isNotEmpty(filterReq.getCourseMode())) {
//			enq.setCourseMode(filterReq.getCourseMode());
//		}
//		if(StringUtils.isNotEmpty(filterReq.getCourseName())) {
//			enq.setCourseMode(filterReq.setCourseName());
//		}
//		if(StringUtils.isNotEmpty(filterReq.getEnqStatus())) {
//			enq.setCourseMode(filterReq.setEnqStatus());
//		}
//		Counsellor c=conrepo.findById(counsellorid).orElse(null);
//		enq.setCounsellor(c);
//		Example<Enquiry> off=new Example.of(enq);
//		List<Enquiry> enqlist=enqrepo.findAll(off);
//		return enqlist;
//	}

	@Override
	public Enquiry getEnquiryById(Integer enqid) {
		// TODO Auto-generated method stub
		return enqrepo.findById(enqid).orElse(null);
		
	}

}
