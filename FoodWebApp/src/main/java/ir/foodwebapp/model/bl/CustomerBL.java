package ir.foodwebapp.model.bl;

import ir.foodwebapp.model.da.CustomerDA;
import ir.foodwebapp.model.entity.Customer;

import java.util.List;

public class CustomerBL {
    private static CustomerBL customerBL = new CustomerBL();

    private CustomerBL() {
    }

    public static CustomerBL getCustomerBL() {
        return customerBL;
    }

    public Customer add(Customer customer) throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.add(customer);
        }
    }

    public Customer edit(Customer customer) throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.edit(customer);
        }
    }

    public Customer remove(long id) throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.remove(id);
        }
    }

    public List<Customer> findByNameAndFamily(String name, String family) throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.findByNameAndFamily(name, family);
        }
    }

    public Customer findById(long id) throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.findById(id);
        }
    }

    public List<Customer> findAll() throws Exception {
        try(CustomerDA customerDA = new CustomerDA()){
            return customerDA.findAll();
        }
    }

}
