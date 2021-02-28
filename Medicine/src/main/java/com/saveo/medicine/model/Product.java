package com.saveo.medicine.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @CsvBindByName(column = "c_name")
    private String name;

    @CsvBindByName
    private String c_batch_no;

    @CsvBindByName
    private String  d_expiry_date;

    @CsvBindByName
    private int n_balance_qty;

    @CsvBindByName
    private String c_packaging;

    @Id
    @CsvBindByName
    private String c_unique_code;

    @CsvBindByName
    private String c_schemes;

    @CsvBindByName
    private double n_mrp;

    @CsvBindByName
    private String c_manufacturer;

    @CsvBindByName
    private int hsn_code;



    public String getC_name() {
        return name;
    }

    public void setC_name(String name) {
        this.name = name;
    }

    public String getC_batch_no() {
        return c_batch_no;
    }

    public void setC_batch_no(String c_batch_no) {
        this.c_batch_no = c_batch_no;
    }

    public String getD_expiry_date() {
        return d_expiry_date;
    }

    public void setD_expiry_date(String d_expiry_date) {
        this.d_expiry_date = d_expiry_date;
    }

    public int getN_balance_qty() {
        return n_balance_qty;
    }

    public void setN_balance_qty(int n_balance_qty) {
        this.n_balance_qty = n_balance_qty;
    }

    public String getC_packaging() {
        return c_packaging;
    }

    public void setC_packaging(String c_packaging) {
        this.c_packaging = c_packaging;
    }

    public String getC_unique_code() {
        return c_unique_code;
    }

    public void setC_unique_code(String c_unique_code) {
        this.c_unique_code = c_unique_code;
    }

    public String getC_schemes() {
        return c_schemes;
    }

    public void setC_schemes(String c_schemes) {
        this.c_schemes = c_schemes;
    }

    public double getN_mrp() {
        return n_mrp;
    }

    public void setN_mrp(double n_mrp) {
        this.n_mrp = n_mrp;
    }

    public String getC_manufacturer() {
        return c_manufacturer;
    }

    public void setC_manufacturer(String c_manufacturer) {
        this.c_manufacturer = c_manufacturer;
    }

    public int getHsn_code() {
        return hsn_code;
    }

    public void setHsn_code(int hsn_code) {
        this.hsn_code = hsn_code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "c_name='" + name + '\'' +
                ", c_batch_no='" + c_batch_no + '\'' +
                ", d_expiry_date=" + d_expiry_date +
                ", n_balance_qty=" + n_balance_qty +
                ", c_packaging='" + c_packaging + '\'' +
                ", c_unique_code=" + c_unique_code +
                ", c_schemes='" + c_schemes + '\'' +
                ", n_mrp=" + n_mrp +
                ", c_manufacturer='" + c_manufacturer + '\'' +
                ", hsn_code=" + hsn_code +
                '}';
    }
}
