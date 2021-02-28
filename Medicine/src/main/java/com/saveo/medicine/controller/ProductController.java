package com.saveo.medicine.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import com.saveo.medicine.exception.OutOfStockException;
import com.saveo.medicine.model.MedicineOrder;
import com.saveo.medicine.model.Product;
import com.saveo.medicine.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/v1/product/uploadCSV/{fileName}")
    public ResponseEntity<?> uploadCSV(@PathVariable String fileName){

        String path="src/main/resources/"+fileName;
        try {
            List<Product> products = new CsvToBeanBuilder(new FileReader(path))
                    .withType(Product.class)
                    .build()
                    .parse();
            productService.createProducts(products);

        } catch (FileNotFoundException e) {
            log.error("File Is Not Found in the system, please try again with the correct path. {}",e.getMessage());
            return new ResponseEntity<>("CSV File is not found in the system please try again", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("CSV File is uploaded to the database", HttpStatus.CREATED);

    }

    @GetMapping("/api/v1/product/searchMedicine/{name}")
    public ResponseEntity<?> searchMedicine(@PathVariable String name) {

        return new ResponseEntity<>(productService.searchMedicine(name), HttpStatus.OK);
    }

    @GetMapping("/api/v1/product/getMedicineDetails/{c_unique_code}")
    public ResponseEntity<?> getMedicineDetails(@PathVariable String c_unique_code) {

        return new ResponseEntity<>(productService.getMedicineDetails(c_unique_code), HttpStatus.OK);
    }

    @PostMapping("/api/v1/product/placeorder")
    public ResponseEntity<?> placeorder(@RequestBody MedicineOrder medicineOrder) throws OutOfStockException {

        return new ResponseEntity<>(productService.placeOrder(medicineOrder), HttpStatus.OK);
    }


}
