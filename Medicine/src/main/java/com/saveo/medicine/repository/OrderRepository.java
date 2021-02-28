package com.saveo.medicine.repository;

import com.saveo.medicine.model.MedicineOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MedicineOrder,String> {
}
