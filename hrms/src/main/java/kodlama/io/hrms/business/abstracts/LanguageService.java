package kodlama.io.hrms.business.abstracts;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Language;



public interface LanguageService {
	
	DataResult<List<Language>> add(List<Language> language);
	DataResult<List<Language>> getAll();
	

}
