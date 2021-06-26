package kodlama.io.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobSeekerLanguageService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerlanguage")
@CrossOrigin
public class JobSeekerLanguageController {
	
	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguageController(JobSeekerLanguageService jobSeekerLanguageService) {
		super();
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	
	@PostMapping("add")
	Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
		
	}

}
