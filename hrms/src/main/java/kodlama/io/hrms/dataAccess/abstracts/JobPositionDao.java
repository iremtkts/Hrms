package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.JobPosition;



public interface JobPositionDao extends JpaRepository <JobPosition , Integer>{
	
	boolean getByPositionName (String jobName);

} 

