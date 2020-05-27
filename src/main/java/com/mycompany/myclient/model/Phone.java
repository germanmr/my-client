package com.mycompany.myclient.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    private CountryCode countryCode;

    @ManyToMany
    @JoinTable(name = "PHONE_CLIENT",
            joinColumns = @JoinColumn(name = "PHONE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    private List<Client> clients = new ArrayList<>();

    protected Phone() {
    }

    public Phone(String description, String number) {
        this.description = description;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}