package net.chandol.study.oop.customer;

public class Address {
    private final String state;
    private final String city;

    public Address(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public Address asEnglish(String state, String city) {
        return new Address(state, city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;

    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
