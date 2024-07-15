package Adapters;
import Soyutlar.ICustomerCheckService;
import Varliklar.Customer;

import java.rmi.RemoteException;

import MernisServiceReference.KPSPublicSoapProxy;
public class MernisServiceAdapter implements ICustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) throws RemoteException {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		return 
				client.TCKimlikNoDogrula(customer.NationalityId, 
				customer.FirstName.toUpperCase(),
				customer.LastName.toUpperCase(),	
			    customer.dateOfBirth.getYear());
		
       
		
	}
             
}
