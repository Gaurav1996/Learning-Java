package com.gagrawal.practice.nonaccessmodifiers;

import java.io.Serializable;

public class TransientFinalExample implements Serializable {
    final int customerId; //will be serialized
    transient final String customerName; //constructor initialised so won't be serialised
    transient final int customerAge = 10; // will be serialized
    transient int customerSSN;// not serialized

    public TransientFinalExample(int customerId, String customerName, int customerSSN) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSSN = customerSSN;
    }

    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId
                + ", customerName=" + customerName
                + ", customerAge=" + customerAge
                + ", customerSSN=" + customerSSN
                + "]";
    }
}
