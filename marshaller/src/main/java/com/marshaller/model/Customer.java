package com.marshaller.model;

import lombok.Data;

import java.util.Set;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Data
public class Customer {

    @XmlAttribute
    private String name;

    private String gender;

    private String phoneNo;

    private Address address;

    private Set<Order> orders;

    public Customer() {
    }

    public Customer(String name, String gender, String phoneNo, Address address) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.address = address;
    }
}