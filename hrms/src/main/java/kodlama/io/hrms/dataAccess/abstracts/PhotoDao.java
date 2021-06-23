package kodlama.io.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository <Photo, Integer> {
	@Query("Select cv.cvId From Photo")
	List<Integer> getAllCvId();

}
