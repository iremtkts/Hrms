package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.abstracts.JobSeekersCheckService;
import kodlama.io.hrms.core.utilities.emailValidator.EmailValidator;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private JobSeekersCheckService jobSeekerCheckService;
	
	public JobSeekerManager(JobSeekersCheckService jobSeekerCheckService) {
		super();
		this.jobSeekerCheckService = jobSeekerCheckService;
	}

	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Autowired

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş Arayanlar Listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		try {
			if (!EmailValidator.isValidEmailId(jobSeeker.getEmail())) {
				return new ErrorResult("Error : Geçerli e posta adresi giriniz");
			}
			
			else if (!jobSeekerCheckService.checkIfRealPerson(jobSeeker)) {
				return new ErrorResult("Error : Gerçek bir kişi giriniz ! ");
			}
			else {
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("Kişi sisteme başarıyla kaydedildi");
			}
		} catch (Exception e) {
			return new ErrorResult ("Sistemde kayıtlı olmayan verilerinizi girin");
		}
	}

	
	
	
	 
	}


