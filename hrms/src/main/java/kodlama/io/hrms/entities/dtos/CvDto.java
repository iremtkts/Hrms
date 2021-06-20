package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.Photo;
import kodlama.io.hrms.entities.concretes.Technology;
import kodlama.io.hrms.entities.concretes.WorkExperience;

public class CvDto {
	
	private int cvId;
	private int jobSeekerId;
	private String description;
	private String githubAddress;
	private String linkedinAdress;
	private List <Language> language;
	private List <Technology> technology;
	private List <Photo> photo;
	private List <Education> education;
	private List <WorkExperience> workExperience;
	

}
