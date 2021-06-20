package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CvManager(CvDao cvDao, DtoConverterService dtoConverterService) {
		super();
		this.cvDao = cvDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		return new SuccessDataResult<List<CvDto>> (dtoConverterService.dtoConverter(cvDao.findAll(), CvDto.class));
	}

	@Override
	public DataResult<List<Cv>> getAllJobSeekerId(int id) {
		return new SuccessDataResult<List<Cv>> (this.cvDao.getByJobSeeker_id(id));
	}

}
