package com.ruthwik.service;

import java.util.List;

import com.ruthwik.dto.ViewRespFilter;
import com.ruthwik.entities.Enquiry;

public interface EnquiryService {
	public boolean addEnquiry(Enquiry enq,Integer counsellorid) throws Exception;
	public List<Enquiry> getAllEnq(Integer counsellorid);
	public List<Enquiry> getEnqwithfilter(ViewRespFilter viewfilter, Integer counsellorid);
	public Enquiry getEnquiryById(Integer enqid); 

}
