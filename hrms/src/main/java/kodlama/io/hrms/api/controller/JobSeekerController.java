package kodlama.io.hrms.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/jobseekers")

public class JobSeekerController {
	

	private JobSeekerService jobSeekerService;


	

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	@GetMapping("/getall")
	public DataResult<List <JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();		
	}

	@PostMapping ("/add")
	public Result add (@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.addJobSeeker(jobSeeker); }

	
	/*@PostMapping("/post")
	public Result addJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.addJobSeeker(jobSeeker);

	}*/

}
