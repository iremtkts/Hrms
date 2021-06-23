package kodlama.io.hrms.core.abstracts;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	
	public File convert(MultipartFile multipartfile )throws IOException;
	public Map photoUpload(MultipartFile multipartfile )throws IOException;
	public Map photoDelete(String id) throws IOException;

}
