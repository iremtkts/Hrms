package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;

import kodlama.io.hrms.entities.concretes.City;


@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CityController {
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();	
		}
	
	
	@GetMapping("/getbyid")
	public DataResult<City> getById(@RequestParam("id") int id){
		return cityService.getById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
