package kodlama.io.hrms.core.utilities.emailValidator;

public interface EmailVerificationService {
	
	void sendVerificationCode (String email);
	String codeGenerator();

}
