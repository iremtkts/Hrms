package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkExperience;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;

public interface WorkExperienceService {
	
	Result add(WorkExperience workExperience);
	DataResult<List<WorkExperience>> getWorkExperienceByCvId(int id);

}
