package kodlama.io.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentDao extends JpaRepository <SchoolDepartment,Integer> {

}
