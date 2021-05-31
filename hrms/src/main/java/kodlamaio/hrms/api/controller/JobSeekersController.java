package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value = "/api/jobSeekers")
public class JobSeekersController {
	
	private JobSeekerService service;

	public JobSeekersController(JobSeekerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value = "/getAll")
	public List<JobSeeker> getAll() {
		return this.service.getAll();
	}

}