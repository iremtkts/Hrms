package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.services.MernisCheckService;
import kodlama.io.hrms.core.utilities.emailValidator.EmailValidator;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {
	


	private JobSeekerDao jobSeekerDao ;
	private  MernisCheckService mernisCheckService;

	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao , MernisCheckService mernisCheckService ) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		}



	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {
		try {
			if(!EmailValidator.isValidEmailId(jobSeeker.getEmail())) {
				return new ErrorResult("Mail formata uygun değil!");}
			
			if(mernisCheckService.isRealJobSeeker(jobSeeker)) {
				return new ErrorResult("Kullanıcı gerçek bir kişi değil");
			}
			else {
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("Kullanıcı başarıyla eklendi");
			}
		} catch (Exception e) {
			return new ErrorResult("Sistemde kayıtlı olan email adresinizi giriniz");
		}
		
		}		
		   
			

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		if ( this.jobSeekerDao.findAll().size() > 0
				) {
            return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Success: İş Arayanlar listelendi!");
        }

        return new ErrorDataResult<>(this.jobSeekerDao.findAll(), "Error: Herhangi bir iş arayan bulunamadı!");
    
	}

	
}

