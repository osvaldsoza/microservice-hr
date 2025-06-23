package com.github.osvaldsoza.hrpayroll.services;

import com.github.osvaldsoza.hrpayroll.entities.Payment;
import com.github.osvaldsoza.hrpayroll.entities.Worker;
import com.github.osvaldsoza.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(Long workerId, int days){
        Worker worker = workerFeignClient.findById(workerId).getBody();

        if(worker != null){
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        }else{
            return new Payment();
        }
    }
}
