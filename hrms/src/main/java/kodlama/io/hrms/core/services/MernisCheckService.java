package kodlama.io.hrms.core.services;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
	boolean isRealJobSeeker(JobSeeker jobSeeker);
}
