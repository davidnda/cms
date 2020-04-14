package com.david.cms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    // Above makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID")
    private int  customerId;
    @JsonProperty ("FirstName")
    private String customerFirstName;
    @JsonProperty ("LastName")
    private String customerLastName;
    @JsonProperty ("eMail")
    private String customerEMail;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastNAme) {
        this.customerLastName = customerLastNAme;
    }

    public String getCustomerEMail() {
        return customerEMail;
    }

    public void setCustomerEMail(String customerEMail) {
        this.customerEMail = customerEMail;
    }
}
