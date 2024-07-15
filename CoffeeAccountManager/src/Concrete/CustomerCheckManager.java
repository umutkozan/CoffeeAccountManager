package Concrete;

import Soyutlar.ICustomerCheckService;

import Varliklar.Customer;

public class CustomerCheckManager implements ICustomerCheckService
   {

	@Override
	public boolean CheckIfRealPerson(Customer customer)
	    {
		return true; 	
     	}
          


	}


