package com.marketingapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entity.Lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//http://localhost:8080/viewLeadForm
	
	@RequestMapping("/viewLeadForm")
 public String viewLeadForm() {
		return"create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveLeadInfo(
		 @ModelAttribute Lead lead,
			Model model
			
			) {
		
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(),"Test","Welcome");
		model.addAttribute("msg", "Record is saved");
		return "create_lead";
	}
//		
//		Lead lead=new Lead();
//		lead.setFirstName(dto.getFirstName());
//		lead.setLastName(dto.getLastName());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//		
//		leadService.saveLead(lead);
//		return "create_lead";
	//}
	// http:localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads=leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id,Model model) {
		leadService.deleteById(id);
		List<Lead> leads=leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	@RequestMapping("/update")
	public String updateLeadById(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}	
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto,Model model) {
		leadService.updateLead(dto);
		List<Lead> leads=leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
}
