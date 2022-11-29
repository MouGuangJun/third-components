package com.marshaller.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;

@XmlType(propOrder = {"state", "province", "city", "street", "zip"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Data
public class Address {

    @XmlElement
    private String state;
    @XmlElement
    private String province;
    @XmlElement
    private String city;
    @XmlElement
    private String street;
    @XmlElement
    private String zip;

    public Address() {
        super();
    }

    public Address(String state, String province, String city, String street,
                   String zip) {
        super();
        this.state = state;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zip = zip;
    }
}