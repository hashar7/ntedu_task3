package com.company;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Implements address entity
 */
public class Address {

    /**
     * Country
     */
    private String country;

    /**
     * Region
     */
    private String region;

    /**
     * City
     */
    private String city;

    /**
     * Street
     */
    private String street;

    /**
     * House
     */
    private String house;

    /**
     * Building
     */
    private String building;

    /**
     * Flat
     */
    private String flat;

    /**
     * Constructor that creates address by given parameters:
     *
     * @param country — country,
     * @param city    — city,
     * @param street  — street,
     * @param house   — house,
     * @param flat    — flat.
     */
    public Address(String country, String region, String city,
                   String street, String house, String building, String flat) {
        this.country = Objects.requireNonNullElse(country, "");
        this.region = Objects.requireNonNullElse(region, "");
        this.city = Objects.requireNonNullElse(city, "");
        this.street = Objects.requireNonNullElse(street, "");
        this.house = Objects.requireNonNullElse(house, "");
        this.building = Objects.requireNonNullElse(building, "");
        this.flat = Objects.requireNonNullElse(flat, "");
    }

    /**
     * Gets country name.
     *
     * @return country name.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets region name.
     *
     * @return region name.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Gets street name.
     *
     * @return street name.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets city name.
     *
     * @return city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets house number.
     *
     * @return house number.
     */
    public String getHouse() {
        return house;
    }

    /**
     * Gets building number.
     *
     * @return building number.
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Gets flat number.
     *
     * @return flat number.
     */
    public String getFlat() {
        return flat;
    }

    /**
     * Method sets address from input string.
     *
     * @param in string containing address.
     * @throws IllegalArgumentException if address string is incorrect.
     */
    public void setAddress(String in) throws IllegalArgumentException {
        in = in.trim();
        if (in.contains(".") || in.contains(";")) {
            setComplexAddress(in);
        } else {
            setSimpleAddress(in);
        }
    }

    /**
     * Method creates address from input string if it contains only "," as delimiter.
     * @param in string containing address.
     * @throws IllegalArgumentException if address string is incorrect.
     */
    private void setSimpleAddress(String in) throws IllegalArgumentException {
        String[] split = in.split(",");
        if (split.length != 7) {
            throw new IllegalArgumentException();
        }
        this.country = split[0].trim();
        this.region  = split[1].trim();
        this.city    = split[2].trim();
        this.street  = split[3].trim();
        this.house   = split[4].trim();
        this.building= split[5].trim();
        this.flat    = split[6].trim();
    }

    /**
     * Method creates address from input string if it contains only "," as delimiter.
     * @param in
     * @throws IllegalArgumentException
     */
    private void setComplexAddress(String in) throws IllegalArgumentException {
        StringTokenizer stringTokenizer = new StringTokenizer(in, ",.;-");
        if (stringTokenizer.countTokens() != 7) {
            throw new IllegalArgumentException();
        }
        this.country = stringTokenizer.nextToken().trim();
        this.region  = stringTokenizer.nextToken().trim();
        this.city    = stringTokenizer.nextToken().trim();
        this.street  = stringTokenizer.nextToken().trim();
        this.house   = stringTokenizer.nextToken().trim();
        this.building= stringTokenizer.nextToken().trim();
        this.flat    = stringTokenizer.nextToken().trim();
    }

    /**
     * Overridden {@link Object#equals(Object)} method for correct object comparison.
     *
     * @param object — object to compare.
     * @return true if objects are equal, flase otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address) object;
        return this.country.equals(((Address) object).country) &&
                this.region.equals(((Address) object).region) &&
                this.city.equals(((Address) object).city) &&
                this.street.equals(((Address) object).street) &&
                this.house.equals(((Address) object).house) &&
                this.building.equals(((Address) object).building) &&
                this.flat.equals(((Address) object).flat);
    }

    /**
     * Overridden {@link Object#toString()} method for correct string representation.
     * @return string representation of {@link Address} class.
     */
    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}