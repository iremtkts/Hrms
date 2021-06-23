package kodlama.io.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Photo;

public interface PhotoService {
	Result add (Photo photo , MultipartFile multipartFile) throws IOException;
	
	Result delete(String id ) throws IOException;
	

}
