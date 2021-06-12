package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SystemPersonnelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{
	private SystemPersonnelDao systemPersonnelDao;
	private EmployerDao employerDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, EmployerDao employerDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>> 
		(this.systemPersonnelDao.findAll(),"Sistem personelleri listelendi.");
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult("Sistem Personeli Başarıyla Eklendi");
	}

	@Override
	public Result confirmEmployer(int systemPersonnelId, boolean confirm) {
		Employer employer = new Employer();
		employer = employerDao.getOne(systemPersonnelId);
		employer.setConfirm(confirm);
		employerDao.save(employer);
		if(confirm == true) {
			return new SuccessResult ("Şirket Kaydı Gerçekleştirildi " + employer.getCompanyName());
		} return new SuccessResult ("Şirket Kaydı İptal Edildi " + employer.getCompanyName());
	}
	
	
}
