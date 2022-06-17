package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {
    private static Customer customer;
    private String firstName;
    private String lastName;
    public void addCustomer(String firstName, String lastName, String email){
        Customer customer1= new Customer(firstName, lastName, email);
    }
    public Customer getCustomer(String customerEmail){
        Customer customer1= new Customer(firstName, lastName, customerEmail);
        return customer1;
    }
    public static Collection<Customer> getAllCustomer(){
        Collection<Customer> customers = new ArrayList<>();
        customers.add(customer);
        return customers;
    }
}
