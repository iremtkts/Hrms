package kodlama.io.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerLanguageService;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlama.io.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService{
	
	private JobSeekerLanguageDao jobSeekerLanguageDao;

	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult("cv'ye yabancı dil başarıyla eklendi");
	}

	

}
