package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {
    private Customer customer;
    private String firstName;
    private String lastName;
    public void addCustomer(String firstName, String lastName, String email){
        Customer newCustomer = new Customer(firstName,lastName,email);
    }
    public Customer getCustomer(String customerEmail){
        return customer;
    }
    public Collection<Customer> getAllCustomer(){
        Customer modelCustomer= new Customer();
    }
}
