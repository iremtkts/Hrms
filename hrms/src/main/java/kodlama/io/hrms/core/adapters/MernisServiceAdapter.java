package kodlama.io.hrms.core.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlama.io.hrms.core.abstracts.JobSeekersCheckService;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements JobSeekersCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		
		var result = true ;
		
		try {
			result = proxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()),
					jobSeeker.getFirstName().toUpperCase(new Locale("tr")), 
					jobSeeker.getLastName().toUpperCase(new Locale("tr")),
					jobSeeker.getBirthDate());
		}  catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
