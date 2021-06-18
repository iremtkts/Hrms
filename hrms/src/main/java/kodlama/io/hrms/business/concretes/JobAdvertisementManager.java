package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;
	
	
    @Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	
	

	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements) , "iş ilanları listelendi");
	}

	@Override
	public DataResult<JobAdvertisementAddDto> add(JobAdvertisementAddDto jobAdvertisement) {
		JobAdvertisement jobAdvertisements= modelMapper.map(jobAdvertisement, JobAdvertisement.class);
		jobAdvertisementDao.save(jobAdvertisements);
		return new SuccessDataResult<JobAdvertisementAddDto>(jobAdvertisement , "iş ilanı başarıyla eklendi");
	}
	
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSorted() {
		Sort sort = Sort.by(Direction.ASC , "applicationDeadline");
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll(sort);
		return new SuccessDataResult<List<JobAdvertisementDto>> (jobAdvertisementToDto(jobAdvertisements) , "iş ilanı taihe göre listelendi");
		}


	@Override
	public DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted() {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.getAllIsActiveSorted();
		return new SuccessDataResult<List<JobAdvertisementDto>> (jobAdvertisementToDto(jobAdvertisements) , "aktif iş ilanlar listelendi");
		
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByEmployer_id(int id) {
		List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.getByEmployer_id(id);
		return new SuccessDataResult<List<JobAdvertisementDto>> (jobAdvertisementToDto(jobAdvertisements) , "firmaya ait iş ilanları listelendi");

	}

	@Override
	public Result updateJobAdvertisementSetIsActiveForEmployer_id(int jobAdvertisementId,
			int employerId) {
		this.jobAdvertisementDao.getByJobAdvertisementIdAndEmployer_id(jobAdvertisementId, employerId);
		return new SuccessResult("iş ilanı kapatıldı"); 
				
	}
	
	private List<JobAdvertisementDto>jobAdvertisementToDto(List<JobAdvertisement> jobAdvertisements){
		return jobAdvertisements.stream().map(Advertisement ->
		modelMapper.map(Advertisement, JobAdvertisementDto.class)).collect(Collectors.toList());
	}




	

}
