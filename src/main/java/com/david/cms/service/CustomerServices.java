package com.david.cms.service;

import com.david.cms.dao.CustomerDAO;
import com.david.cms.exception.CustomerNotFoundException;
import com.david.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component


public class CustomerServices {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount =1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;

        //return customer;
        return  customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {

        //return customerList;
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) {
//        return customerList
//                    .stream()
//                    .filter(c -> c.getCustomerId() == customerId)
//                    .findFirst()
//                    .get();

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Doh customer is not found");

        return optionalCustomer.get()
                ;
    }

    public Customer updateCustomer (int customerId, Customer customer) {

        System.out.println(customer.getCustomerId());
//        customerList
//                .stream()
//                .forEach(c -> {
//                            if (c.getCustomerId() == customerId) {
//                                c.setCustomerFirstName(customer.getCustomerFirstName());
//                                c.setCustomerLastName(customer.getCustomerLastName());
//                                c.setCustomerFirstName(customer.getCustomerFirstName());
//                            }
//                        }
//                );
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

        // save is for create and update
        // if id is missing it will do a create
        customer.setCustomerId(customerId);

        System.out.println(customer.getCustomerId());
        System.out.println(customer.getCustomerFirstName());
        System.out.println(customer.getCustomerLastName());
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
//        customerList
//                .stream()
//                .forEach(customer -> {
//                    if (customer.getCustomerId() == customerId) {
//                        customerList.remove(customer);
//                    }
//                });

        customerDAO.deleteById(customerId);
    }
}
