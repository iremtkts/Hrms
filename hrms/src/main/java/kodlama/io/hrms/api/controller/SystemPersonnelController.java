package kodlama.io.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SystemPersonnelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.SystemPersonnel;


@RestController
@RequestMapping("api/systempersonnel")

public class SystemPersonnelController {
	private SystemPersonnelService systemPersonnelService;

	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.systemPersonnelService.getAll();
		}
	
	@PostMapping("/add")
	
	public ResponseEntity<?> add(@RequestBody @Valid SystemPersonnel systemPersonnel){
		return ResponseEntity.ok(this.systemPersonnelService.add(systemPersonnel));
	}
	
	@PostMapping("/confirmUser")
	
	public ResponseEntity<?> confirmUser(@Valid @RequestParam("id")int employerId,@RequestParam("confirm") boolean confirm){
		return ResponseEntity.ok(this.systemPersonnelService.confirmEmployer(employerId, confirm));
	}

}
