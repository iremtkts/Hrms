package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.ValidationService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public class ValidationManager implements ValidationService{
	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	private UserDao userDao;

	
	@Autowired
	public ValidationManager(JobSeekerDao jobSeekerDao, EmployerDao employerDao, UserDao userDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.employerDao = employerDao;
		this.userDao = userDao;
	}

	@Override
	public Result mailExist(Employer employer) {
		if (this.userDao.existsByEmailAdress(employer.getEmail())) {
            return new ErrorResult("Email Adresi Kayıtlı"); }
	
	return new SuccessResult();
	}



	@Override
	public Result mailExist(JobSeeker jobSeeker) {
		if (this.userDao.existsByEmailAdress(jobSeeker.getEmail())) {
            return new ErrorResult("Email Adresi Kayıtlı"); }
	
	return new SuccessResult();
	}
	

	

	@Override
	public Result requiredEmployer(Employer employer) {
		if (employer.getCompanyName() == null || employer.getCompanyName().isBlank() || employer.getWebsiteAdress() == null || 
				employer.getWebsiteAdress().isBlank() || employer.getEmail() == null ||
				employer.getEmail().isBlank() || employer.getPassword() == null || employer.getPassword().isBlank()) {
            return new ErrorResult("Tüm Alanları Doldurunuz");
        } else {

            return new SuccessResult();
        }
	}

	@Override
	public Result requiredCandidate(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName() == null || jobSeeker.getFirstName().isBlank() || jobSeeker.getLastName() == null ||
				jobSeeker.getLastName().isBlank() || jobSeeker.getEmail() == null || 
				jobSeeker.getEmail().isBlank() || 
				jobSeeker.getBirthDate() == null && jobSeeker.getIdentityNumber() == null ||
						jobSeeker.getIdentityNumber().isBlank() || jobSeeker.getPassword() == null || 
								jobSeeker.getPassword().isBlank()) {
            return new ErrorResult("Tüm Alanları doldurunuz");

        } else {
            return new SuccessResult();
    }
	}






	

}
