package kodlama.io.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;
import java.util.List;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("api/cvs")
public class CvController {
	
	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
	DataResult<List<CvDto>> getAll(){
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
		}
	
	@GetMapping("/getAllJobSeekerId")
	DataResult<List<Cv>> getAllJobSeekerId(@RequestParam int id){
		return this.cvService.getAllJobSeekerId(id);
	}

	
}
