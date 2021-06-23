package kodlama.io.hrms.business.concretes;

import java.io.IOException;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.core.abstracts.CloudinaryService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.PhotoDao;
import kodlama.io.hrms.entities.concretes.Photo;
@Service
public class PhotoManager implements PhotoService{
	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Photo photoUrl, MultipartFile multipartFile) throws IOException {

		
		
		Result result = new ErrorResult("Tekrar deneyin");
		Map uploader = (Map) this.cloudinaryService.photoUpload(multipartFile);
		photoUrl.setPhotoUrl(((java.util.Map) uploader).get("url").toString());
		if(this.photoDao.getAllCvId().contains(photoUrl.getPhotoId())) {
			result = new SuccessResult("fotoğrafınız eklendi ");
			this.photoDao.save(photoUrl);
		}
		return result;
	}

	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryService.photoDelete(id);
		return new SuccessResult("fotoğraf başarıyla silindi");
	}

}
