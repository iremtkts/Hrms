package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlama.io.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{
	
	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("iş deneyimi bilgisi başarıyla eklendi");
		
	}

	@Override
	public DataResult<List<WorkExperience>> getWorkExperienceByCvId(int id) {
		Sort sort = Sort.by(Sort.Direction.DESC , "endDate");
		
		return new SuccessDataResult<>(this.workExperienceDao.getWorkExperienceEndDateByCv_cvId(id, sort), 
				"iş deneyimleri başarıyla sıralandı");
	}

}
