package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.verification.EmailValidator;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	

	private EmployerDao employerDao;
    @Autowired

	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	
	

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(), "İşverenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		String [] employerWebsite = employer.getWebsiteAdress().split("\\." , 2);
		String website = employerWebsite[1];
		
		
		String [] employerMail = employer.getEmail().split("@");
		String employerDomain = employerMail[1];
		
		
		try {
			if (!EmailValidator.isValidEmailId(employer.getEmail())) {
				return new ErrorResult("Geçersiz mail adresi girdiniz!");
			} else if (!employerDomain.equals(website)) {
				return new ErrorResult ("Website ile mail aynı domaine sahip değil !");
				
			} else {
				this.employerDao.save(employer);
				return new SuccessResult ("İşveren Kullanıcı Sisteme Eklendi");
				
			}
		} catch (Exception e) {
			return new ErrorResult("Kullanıcı sistemde kayıtlı");
		}
	}

}
