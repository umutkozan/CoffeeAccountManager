package Soyutlar;

import java.rmi.RemoteException;

import Varliklar.Customer;

public interface ICustomerCheckService {
	boolean CheckIfRealPerson(Customer customer) throws RemoteException;
}

