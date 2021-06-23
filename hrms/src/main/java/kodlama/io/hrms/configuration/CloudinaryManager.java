package kodlama.io.hrms.configuration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager {
	
	Cloudinary cloudinary;
	
	public CloudinaryManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name" , "dwkhcbnhi",
				"api_key" , "863253873129419" ,
				"api_secret" , "290QEhaWv31C-7djHxeNfN9HogA"
				
				));
	}

	public Map upload (MultipartFile multipartFile) throws IOException{
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}
	
	public Map delete (String id ) throws IOException{
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}

	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream f = new FileOutputStream(file);
		f.write(multipartFile.getBytes());
		f.close();
		return file;
	}
}
