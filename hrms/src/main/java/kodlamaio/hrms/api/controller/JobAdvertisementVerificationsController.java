package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementVerification;

@RestController
@RequestMapping(value = "/api/jobAdvertisementVerification")
public class JobAdvertisementVerificationsController {
	
	private JobAdvertisementVerificationService verificationService;

	@Autowired
	public JobAdvertisementVerificationsController(JobAdvertisementVerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobAdvertisementVerification advertisementVerification) {
		return this.verificationService.add(advertisementVerification);
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<JobAdvertisementVerification>> getAll() {
		return this.verificationService.getAll();
	}
	
	@GetMapping(value = "/getById")
	public DataResult<JobAdvertisementVerification> getByJobAdvertisementVerificationId(@RequestParam int id) {
		return this.verificationService.getByJobAdvertisementVerificationId(id);
	}
	

}
