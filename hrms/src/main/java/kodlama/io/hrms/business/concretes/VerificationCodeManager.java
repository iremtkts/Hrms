package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlama.io.hrms.entities.concretes.VerificationCode;

public class VerificationCodeManager implements VerificationCodeService {
	
	private VerificationCodeDao verificationCodeDao;
	
    @Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult("Doğrulama kodları eklendi ");
		
	}

	@Override
	public DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
		return new SuccessDataResult<VerificationCode> (this.verificationCodeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	}

	@Override
	public Result update(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult("Doğrulama kodları güncellendi");
	}

	
}
