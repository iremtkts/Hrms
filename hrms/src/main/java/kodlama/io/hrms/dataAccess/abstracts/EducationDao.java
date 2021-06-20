package kodlama.io.hrms.dataAccess.abstracts;




import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository <Education , Integer> {

	Education getByEducationId(int educationId);
	
}
