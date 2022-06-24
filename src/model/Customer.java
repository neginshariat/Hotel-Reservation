package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public String getEmail() {
        return email;
    }

    private final String emailREX= "^(.+)@(.+).(.+)$";
    private final Pattern pattern= Pattern.compile(emailREX);
    public Customer(String firstName, String lastName, String email){
        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Invalid email");
        }
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
