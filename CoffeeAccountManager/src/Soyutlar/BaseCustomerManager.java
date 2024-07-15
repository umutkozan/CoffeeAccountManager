package Soyutlar;

import Varliklar.Customer;

public abstract class BaseCustomerManager implements ICustomerService {

	
	public  void Save(Customer customer) throws Exception {
		System.out.println("Veritabanına kaydedildi.");
		
	}

}
