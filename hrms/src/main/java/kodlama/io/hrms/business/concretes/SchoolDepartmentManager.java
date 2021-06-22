package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlama.io.hrms.entities.concretes.SchoolDepartment;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService{
	
	private SchoolDepartmentDao schoolDepartmentDao;

	@Autowired
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
		super();
		this.schoolDepartmentDao = schoolDepartmentDao;
	}

	@Override
	public Result add(SchoolDepartment schoolDepartment) {
		this.schoolDepartmentDao.save(schoolDepartment);
		return new SuccessResult("okul bölüm bilgisi eklendi");
	}

	@Override
	public DataResult<List<SchoolDepartment>> getAll() {
		return new SuccessDataResult<>(this.schoolDepartmentDao.findAll(),"okul bölüm bilgileri listelendi");
	}

}
