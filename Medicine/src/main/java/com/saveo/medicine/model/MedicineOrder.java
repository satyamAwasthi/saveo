package com.saveo.medicine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicineOrder {

    @Id
    private String orderId;

    private String c_unique_code;

    private int quantity;

    private String c_name;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getC_unique_code() {
        return c_unique_code;
    }

    public void setC_unique_code(String c_unique_code) {
        this.c_unique_code = c_unique_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", c_unique_code=" + c_unique_code +
                ", quantity=" + quantity +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}
