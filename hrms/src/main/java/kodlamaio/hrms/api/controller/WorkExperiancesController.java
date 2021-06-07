package kodlamaio.hrms.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperianceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperiance;

@RestController
@RequestMapping(value = "/api/workExperiances")
public class WorkExperiancesController {
	
	private WorkExperianceService experianceService;

	public WorkExperiancesController(WorkExperianceService experianceService) {
		super();
		this.experianceService = experianceService;
	}
	
	@PostMapping(value = "/add")
	Result add(@RequestBody WorkExperiance workExperiance) {
		return this.experianceService.add(workExperiance);
	}
	
	@GetMapping(value = "/getAll")
	DataResult<WorkExperiance> getByJobSeeker(@RequestParam int jobSeekerId) {
		return this.experianceService.getByJobSeeker(jobSeekerId);
	}
	
	@DeleteMapping("/delete")
	Result delete(@RequestParam int id) {
		return this.experianceService.delete(id);
	}

}