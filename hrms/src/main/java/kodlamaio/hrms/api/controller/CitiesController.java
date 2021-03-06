package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("api/cities")
public class CitiesController {

	private CityService service;

	@Autowired
	public CitiesController(CityService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<City> getById(@RequestParam int id) {
		return this.service.getById(id);
	}

}
