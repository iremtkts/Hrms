package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkController {
	
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("getall")
	DataResult<List<WorkExperience>> getWorkExperienceByCvId(int id){
		return this.workExperienceService.getWorkExperienceByCvId(id);
	}
	
	@PostMapping("/add")
	
	Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
	

}
