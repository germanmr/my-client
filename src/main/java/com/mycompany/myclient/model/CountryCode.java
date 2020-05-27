package com.mycompany.myclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CountryCode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="countryCode")
    private Phone phone;

    protected CountryCode() {
    }

    public CountryCode(String name,String code) {
        this.name = name;
        this.code=code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CountryCode{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}