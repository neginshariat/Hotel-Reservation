package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private final static Map<String,Customer> customers= new HashMap<>();
    private final CustomerService customerService= new CustomerService();
    private CustomerService(){}
    public void addCustomer(String firstName, String lastName, String email){
        customers.put(email,new Customer(firstName, lastName, email));
    }
     public Customer getCustomer(String customerEmail){
        return customers.get(customerEmail);
    }
    public  Collection<Customer> getAllCustomer(){
        return customers.values();
    }
}
