package apiStream.domain.models;

import apiStream.domain.enums.CustomerType;

public class Customer {
    private long clientId;
    private String name;
    private CustomerType tier;

    public Customer(long id, String name, CustomerType tier) {
        this.clientId = id;
        this.name = name;
        this.tier = tier;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getTier() {
        return tier;
    }

    public void setTier(CustomerType tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + clientId +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
