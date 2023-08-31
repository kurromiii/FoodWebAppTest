package ir.foodwebapp.controller;

import ir.foodwebapp.model.bl.CustomerBL;
import ir.foodwebapp.model.bl.OrderBL;
import ir.foodwebapp.model.entity.Customer;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class CustomerController {
    private static CustomerController customerController = new CustomerController();

    private CustomerController() {
    }

    public static CustomerController getCustomerController() {
        return customerController;
    }

    public String add(String name, String family, String phoneNumber) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty() && phoneNumber != null &&
                    !phoneNumber.isEmpty()) {
                if (phoneNumber.length() == 11) {
                    Customer customer = new Customer(name, family, phoneNumber);
                    return CustomerBL.getCustomerBL().add(customer).toString();
                } else {
                    throw new ValueException("Enter phoneNumber correctly!");
                }
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

    public String edit(String name, String family, String phoneNumber, boolean status) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty() && phoneNumber != null &&
                    !phoneNumber.isEmpty() && status == true) {
                if (phoneNumber.length() == 11) {
                    Customer customer = new Customer(name, family, phoneNumber, status);
                    return CustomerBL.getCustomerBL().edit(customer).toString();
                } else {
                    throw new ValueException("Enter phoneNumber correctly!");
                }
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String remove(long id){
        try {
            if (id != 0) {
                return CustomerBL.getCustomerBL().remove(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

    public String findByNameAndFamily(String name, String family) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty()) {
                return CustomerBL.getCustomerBL().findByNameAndFamily(name,family).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String findById(long id) {
        try {
            if (id != 0) {
                return CustomerBL.getCustomerBL().findById(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

}

