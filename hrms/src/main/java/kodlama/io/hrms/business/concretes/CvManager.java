package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;


@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
		
	}


	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult ("Cv'niz başarıyla eklendi");
	}


	

	@Override
	public DataResult<List<Cv>> findByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.cvDao.findByJobSeekerId(jobSeekerId));
	}


}
