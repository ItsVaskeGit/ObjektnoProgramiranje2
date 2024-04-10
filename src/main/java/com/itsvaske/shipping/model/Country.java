package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Country.GET_ALL_COUNTRIES, query = "select c from Country c"),
        @NamedQuery(name = Country.GET_COUNTRY_BY_CODE, query = "select c from Country c where c.countryCode =: countryCode")
})
public class Country {

    public static final String GET_ALL_COUNTRIES = "getAllCountries";
    public static final String GET_COUNTRY_BY_CODE = "getCountryByCode";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Country_seq")
    private Long id;

    private String countryCode;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
