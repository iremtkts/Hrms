package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;


public interface CvService {
	
	Result add(Cv cv);
	
	DataResult<List<Cv>> findByJobSeekerId(int jobSeekerId );

}
