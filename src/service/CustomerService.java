package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {
    private static Customer customer;
    private final static List<Customer> customerList= new ArrayList<>();
    private String firstName;
    private String lastName;
    public void addCustomer(String firstName, String lastName, String email){
        Customer customer1= new Customer(firstName, lastName, email);
        customerList.add(customer1);
    }
    public Customer getCustomer(String customerEmail){
        //Customer customer1= new Customer(firstName, lastName, customerEmail);
        Customer customer1= new Customer(customer.getFirstName(), customer.getLastName(), customerEmail);
        return customer1;
    }
    public static Collection<Customer> getAllCustomer(){
        return customerList;
    }
}
