package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entity.Lead;
import com.marketingapp.exception.ResourceNotFoundException;
import com.marketingapp.repository.LeadRepository;



//we can develop API"S by  adding @RestController
@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:8080/api/leads
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads=leadRepo.findAll();
		return leads;
}
	
	@PostMapping
	public ResponseEntity<?> saveLead(
			
			@Valid @RequestBody Lead lead,
			BindingResult result
			
			){
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Lead saveLead=leadRepo.save(lead);
		return new ResponseEntity<>(saveLead,HttpStatus.CREATED);
		
	}
	//http://localhost:8080/api/lead/{id}
	@PutMapping("{id}")
	public ResponseEntity<Lead> updateLead(
			@PathVariable long id,
			@RequestBody LeadDto dto
			) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead=findById.get();
		
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadRepo.save(lead);
		
		return new ResponseEntity<>(lead,HttpStatus.OK);
		
	}
	
	//http://localhost:8080/api/lead/{id}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLeadById(@PathVariable long id){
		
		Lead lead=leadRepo.findById(id).
										orElseThrow(
												
												()->new ResourceNotFoundException("Lead not found")
												
												);
		
		leadRepo.deleteById(id);
		return new ResponseEntity<String>("Lead is deleted",HttpStatus.OK);
	}
	
		
}
	
