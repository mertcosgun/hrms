package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkedAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkedAccount;

@RestController
@RequestMapping(value = "/api/linkedAccounts")
public class LinkedAccountsController {
	
	private LinkedAccountService accountService;

	@Autowired
	public LinkedAccountsController(LinkedAccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody LinkedAccount linkedAccount) {
		return this.accountService.add(linkedAccount);
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<LinkedAccount>> getAll() {
		return this.accountService.getAll();
	}
	
	@GetMapping(value = "/getByResumeId")
	public DataResult<List<LinkedAccount>> getByResumeId(@RequestParam int resumeId) {
		return this.accountService.getByResumeId(resumeId);
	}
}
