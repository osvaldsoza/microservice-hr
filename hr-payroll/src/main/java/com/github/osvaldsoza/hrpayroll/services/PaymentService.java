package com.github.osvaldsoza.hrpayroll.services;

import com.github.osvaldsoza.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Bob", 120.0, days);
    }
}
