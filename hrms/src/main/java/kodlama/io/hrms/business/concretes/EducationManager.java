package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {
	private EducationDao educationDao;
	

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
		
	}


	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<>(this.educationDao.findAll(), "eğitim bilgileri listelendi");
	}


	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult ("eğitim bilgileri eklendi");
	}


	@Override
	public DataResult<List<Education>> OrderByEndedDate(int cvId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"endedDate");
		return new SuccessDataResult<>(this.educationDao.getEducationEndDateByCv_cvId(cvId, sort));
		
	}


	@Override
	public Result showEducationStatus(Education education) {
		if(((List<Education>) education.getEndingDate()).isEmpty());
		return new SuccessResult("devam ediyor");
				}


}

