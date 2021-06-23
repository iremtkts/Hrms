package kodlama.io.hrms.core.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.configuration.CloudinaryManager;
import kodlama.io.hrms.core.abstracts.CloudinaryService;

@Service
public class CloudinaryManagerAdapter implements CloudinaryService {
	
	private CloudinaryManager cloudinaryManager;

	@Autowired
	public CloudinaryManagerAdapter(CloudinaryManager cloudinaryManager) {
		super();
		this.cloudinaryManager = cloudinaryManager;
	}

	@Override
	public File convert(MultipartFile multipartfile) throws IOException {
		return this.cloudinaryManager.convert(multipartfile);
	}

	@Override
	public Map photoUpload(MultipartFile multipartfile) throws IOException {
		return this.cloudinaryManager.upload(multipartfile);
	}

	@Override
	public Map photoDelete(String id) throws IOException {
		return this.cloudinaryManager.delete(id);
	}

}
