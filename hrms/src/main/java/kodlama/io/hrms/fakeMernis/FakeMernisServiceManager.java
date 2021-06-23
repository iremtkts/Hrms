package kodlama.io.hrms.fakeMernis;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.MernisCheckService;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class FakeMernisServiceManager implements MernisCheckService {

	@Override
	public boolean isRealJobSeeker(JobSeeker jobSeeker) {
		return jobSeeker.getIdentityNumber().length() == 11;
	}

}
