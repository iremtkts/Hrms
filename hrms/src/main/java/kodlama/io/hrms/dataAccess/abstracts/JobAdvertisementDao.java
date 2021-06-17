package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement , Integer>{
	
	@Query("Select j from JobAdvertisement j Where j.isActive = true order by j.applicationDeadlineDate desc")
	List<JobAdvertisement> getAllIsActiveSorted();
	
	JobAdvertisement findByJobAdvertisementId(int id);
	
	JobAdvertisement getByJobAdvertisementIdAndEmployer_id(int jobAdvertisementId, int id);
	
	List <JobAdvertisement> getByEmployer_id(int id);
	
	
	@Modifying
	@Query("update JobAdvertisement set isActive=false where jobAdvertisementId=:jobAdvertisementId and employer_id=:employerId")
	
	int updateJobAdvertisementSetIsActiveForEmployer_id(
			@Param("jobAdvertisementId") int jobAdvertisementId , @Param ("employerId") int employerId);
	
	
   
	



}
