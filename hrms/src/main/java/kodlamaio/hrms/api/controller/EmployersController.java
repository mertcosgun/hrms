package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping(value = "/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService service;

	@Autowired
	public EmployersController(EmployerService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/getAll")
	public DataResult<List<Employer>> getAll() {
		return this.service.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Employer employer) {
		return this.service.add(employer);
	}
	@GetMapping(value = "/getById")
	public DataResult<Employer> getById(int id) {
		return this.service.getById(id);
	}
}
