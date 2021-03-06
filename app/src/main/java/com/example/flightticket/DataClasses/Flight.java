package com.example.flightticket.DataClasses;

import java.util.Objects;

public class Flight {
    private int id;
    private Integer minPrice;
    private String carrier;
    private Place placeDep;
    private Place placeDist;
    private String currency;

    public Flight(int id, Integer minPrice, String carrier, Place placeDep, Place placeDist, String currency) {
        this.id = id;
        this.minPrice = minPrice;
        this.carrier = carrier;
        this.placeDep = placeDep;
        this.placeDist = placeDist;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Place getPlaceDep() {
        return placeDep;
    }

    public void setPlaceDep(Place placeDep) {
        this.placeDep = placeDep;
    }

    public Place getPlaceDist() {
        return placeDist;
    }

    public void setPlaceDist(Place placeDist) {
        this.placeDist = placeDist;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId()
                && getMinPrice().equals(flight.getMinPrice())
                && Objects.equals(getCarrier(), flight.getCarrier())
                && Objects.equals(getPlaceDep(), flight.getPlaceDep())
                && Objects.equals(getPlaceDist(), flight.getPlaceDist())
                && Objects.equals(getCurrency(), flight.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMinPrice(), getCarrier(), getPlaceDep(), getPlaceDist(), getCurrency());
    }

    @Override
    public String toString() {
        return "\nFlight{" +
                "\nid=" + id +
                ",\n minPrice=" + minPrice +
                ",\n carrier='" + carrier + '\'' +
                ",\n placeDep=" + placeDep +
                ",\n placeDist=" + placeDist +
                ",\n currency='" + currency + '\'' +
                '}';
    }
}
