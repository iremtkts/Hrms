package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.TechnologyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")

public class TechnologyController {
	
	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Technology>> getAll(){
	
		return this.technologyService.getAll();
		
	}
	
	
	@PostMapping("/add")
	Result add(@RequestBody Technology tech) {
		return this.technologyService.add(tech);
	}
}
