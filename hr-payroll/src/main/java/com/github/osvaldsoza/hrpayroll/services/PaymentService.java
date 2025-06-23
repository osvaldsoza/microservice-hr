package com.github.osvaldsoza.hrpayroll.services;

import com.github.osvaldsoza.hrpayroll.entities.Payment;
import com.github.osvaldsoza.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {


    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String hrWorkerHost;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Payment getPayment(Long workerId, int days){

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));
        Worker worker = restTemplate.getForObject(hrWorkerHost + "/workers/{id}", Worker.class, uriVariables);

        if(worker != null){
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        }else{
            return new Payment();
        }

    }
}
