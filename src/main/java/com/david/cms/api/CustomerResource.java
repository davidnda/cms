package com.david.cms.api;

import com.david.cms.model.Customer;
import com.david.cms.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping
//    @RequestMapping(value = "/create")
    public Customer addCustomer(@RequestBody  Customer customer) {
        return customerServices.addCustomer(customer);
    };

    @GetMapping
    public List<Customer> getCustomers() {
        return customerServices.getCustomers();
    }

    @GetMapping(value = "/{customerID}")
    public Customer getCustomer (@PathVariable("customerID") int customerId){
        return customerServices.getCustomer(customerId);

        // request looks like localhost:8080/customer/4
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer (@PathVariable("customerId") int customerId , @RequestBody Customer customer) {
        System.out.println("here");
        return customerServices.updateCustomer(customerId,customer);
    }

    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerServices.deleteCustomer(customerId);
    }
}
