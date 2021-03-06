package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;


public interface ValidationService {
	
	
	 Result mailExist(Employer employer) ;
	 Result mailExist(JobSeeker jobSeeker) ;
	 Result requiredEmployer(Employer employer);
	 Result requiredJobSeeker(JobSeeker jobSeeker);
	

}
