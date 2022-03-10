package com.cjc.main.homerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}
