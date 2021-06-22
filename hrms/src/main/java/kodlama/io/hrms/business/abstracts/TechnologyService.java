package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Technology;

public interface TechnologyService {
	DataResult<List<Technology>> getAll();
	
	Result add (Technology tech);
	

}
