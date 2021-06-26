package kodlama.io.hrms.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotoController {
	
	private PhotoService photoService;

	@Autowired
	public PhotoController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@PostMapping("/addPhoto")
	public ResponseEntity<?> upload(@ModelAttribute("photo") Photo photo,
			@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.photoService.add(photo, multipartFile) , HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePhoto")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException{
		return new ResponseEntity<>(this.photoService.delete(id) , HttpStatus.OK);
	}

}
