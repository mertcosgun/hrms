package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping(value = "/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<Language>> getAll() {
		return this.languageService.getAll();
	}

}
