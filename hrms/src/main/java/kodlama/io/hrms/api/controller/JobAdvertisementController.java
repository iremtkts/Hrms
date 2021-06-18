package kodlama.io.hrms.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
    @Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
    
    @GetMapping("getAll")
    DataResult<List<JobAdvertisementDto>> getAll(){
    	
    	return this.jobAdvertisementService.getAll();
    }
    
    @PostMapping("/addJobAdvertisement")
    
    ResponseEntity<?> add (@RequestBody JobAdvertisementAddDto jobAdvertisement){
    	return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }
    
    @GetMapping("getAllSorted")
    DataResult<List<JobAdvertisementDto>> getAllSorted(){
    	return this.jobAdvertisementService.getAllSorted();    
    	}
    
    @GetMapping("getAllIsActiveSorted")
    DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted(){
    	return this.jobAdvertisementService.getAllIsActiveSorted();    
    	}
    
    @GetMapping("getByEmployer_id")
    DataResult<List<JobAdvertisementDto>> getByEmployer_id(@RequestParam("id") int id){
    	return this.jobAdvertisementService.getByEmployer_id(id);    
    	}
    
   @PostMapping("/updateJobAdvertisement")
    @Transactional 
    public Result updateJobAdvertisementSetIsActiveForEmployer_id(@RequestParam("jobAdvertisementId") int jobAdvertisementId
    		,@RequestParam("employerId") int employerId ) {
    		return this.jobAdvertisementService.updateJobAdvertisementSetIsActiveForEmployer_id(jobAdvertisementId, employerId);    	
    }

}
