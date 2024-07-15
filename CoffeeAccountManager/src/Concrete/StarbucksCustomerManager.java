package Concrete;

import Soyutlar.BaseCustomerManager;
import Soyutlar.ICustomerCheckService;
import Varliklar.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager  {
	  ICustomerCheckService _customerCheckService;
	  public StarbucksCustomerManager(ICustomerCheckService customerCheckService)
	  {
		  _customerCheckService = customerCheckService;
	  }
	  public void Save(Customer customer) throws Exception {
		  
		  if(_customerCheckService.CheckIfRealPerson(customer)) {
			  
			  Save(customer);
		  }
		  else {
               throw new Exception("Giriş Geçersiz");
		     }
  }
      
   
 }


