package com.saveo.medicine.service;

import com.saveo.medicine.exception.OutOfStockException;
import com.saveo.medicine.model.MedicineOrder;
import com.saveo.medicine.model.Product;

import java.util.List;

public interface ProductService {

    void createProducts(List<Product> products) ;
    Product getMedicineDetails(String c_unique_id);
    String placeOrder(MedicineOrder medicineOrder) throws OutOfStockException;
    List<String> searchMedicine(String name);
}
