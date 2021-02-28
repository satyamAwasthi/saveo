package com.saveo.medicine.service;


import com.saveo.medicine.exception.OutOfStockException;
import com.saveo.medicine.model.MedicineOrder;
import com.saveo.medicine.model.Product;
import com.saveo.medicine.repository.OrderRepository;
import com.saveo.medicine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public ProductServiceImpl(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void createProducts(List<Product> products) {
//        for(Product product: products)
        productRepository.saveAll(products);

    }

    @Override
    public Product getMedicineDetails(String c_unique_code) {
        return productRepository.findById(c_unique_code).get();
    }

    @Override
    public String placeOrder(MedicineOrder medicineOrder) throws OutOfStockException {
        String orderId = UUID.randomUUID().toString();
        medicineOrder.setOrderId(orderId);
        Product product=productRepository.findById(medicineOrder.getC_unique_code()).get();
        int remainingQuantity=product.getN_balance_qty()- medicineOrder.getQuantity();
        if(remainingQuantity>=0) {
            product.setN_balance_qty(remainingQuantity);
            productRepository.save(product);
            orderRepository.save(medicineOrder);
            return orderId;
        }
        else throw new OutOfStockException("Out of Stock. The order can not be processed as the medicine is out of stock.");
    }

    @Override
    public List<String> searchMedicine(String name) {

        List<Product> products= productRepository.findByNameContaining(name);
        List<String> searchResults=new ArrayList<>();
        for (Product product:products)
            searchResults.add(product.getC_name());
        return searchResults;
    }


}
