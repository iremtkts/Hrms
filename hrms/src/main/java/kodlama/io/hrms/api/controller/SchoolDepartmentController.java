package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.hrms.entities.concretes.SchoolDepartment;

import kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/schooldepartments")
public class SchoolDepartmentController {
	
	private SchoolDepartmentService schoolDepartmentService;

	@Autowired
	public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
		super();
		this.schoolDepartmentService = schoolDepartmentService;
	}
	
	@GetMapping("getall")
	DataResult<List<SchoolDepartment>> getAll(){
		return this.schoolDepartmentService.getAll();
	}
	
	@PostMapping("add")
	Result add(SchoolDepartment schoolDepartment) {
		return this.schoolDepartmentService.add(schoolDepartment);
	}
	

}
