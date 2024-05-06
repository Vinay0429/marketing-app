package com.marketingapp.service;

import java.util.List;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entity.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);

	public List<Lead> findAllLeads();

	public void deleteById(long id);

	public Lead findLeadById(long id);

	public void updateLead(LeadDto dto);

}

	
