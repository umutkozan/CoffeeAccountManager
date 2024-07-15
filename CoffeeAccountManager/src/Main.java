

import java.time.LocalDate;

import Adapters.MernisServiceAdapter;
import Concrete.StarbucksCustomerManager;
import Soyutlar.BaseCustomerManager;
import Varliklar.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
        Customer custom = new Customer();
        custom.FirstName="Umut";
        custom.LastName="Kozan";
        custom.id=5;
        custom.dateOfBirth = LocalDate.of(1998,21,12);
        customerManager.Save(custom);
        
     }
}