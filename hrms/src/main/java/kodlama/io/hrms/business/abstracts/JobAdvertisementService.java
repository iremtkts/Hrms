package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisementDto>> getAll();
	DataResult<JobAdvertisementAddDto> add (JobAdvertisementAddDto  jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> getAllSorted();
	DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted();
	DataResult<List<JobAdvertisementDto>> getByEmployer_id(int id);
	Result updateJobAdvertisementSetIsActiveForEmployer_id(int jobAdvertisementId ,int employerId );
	
	
}
