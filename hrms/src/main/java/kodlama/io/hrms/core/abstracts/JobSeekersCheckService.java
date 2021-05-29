package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekersCheckService {
	
	boolean checkIfRealPerson (JobSeeker jobSeeker);

}
