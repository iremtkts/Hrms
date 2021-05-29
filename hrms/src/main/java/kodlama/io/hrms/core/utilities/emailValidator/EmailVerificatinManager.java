package kodlama.io.hrms.core.utilities.emailValidator;

import java.util.UUID;

public class EmailVerificatinManager implements EmailVerificationService{

	@Override
	public void sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink= "https://hrmsverificationmail/" + uuid.toString();	
		//
	}

	@Override
	public String codeGenerator() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
		}

}
