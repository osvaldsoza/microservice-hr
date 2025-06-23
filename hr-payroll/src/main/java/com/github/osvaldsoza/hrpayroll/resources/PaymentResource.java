package com.github.osvaldsoza.hrpayroll.resources;

import com.github.osvaldsoza.hrpayroll.entities.Payment;
import com.github.osvaldsoza.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{workerId}/days/{days}")
    @HystrixCommand(fallbackMethod = "getPaymentFallback")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payment> getPaymentFallback(Long workerId, Integer days) {
        Payment payment = new Payment("MS Worker fora", 0.0, 0);
        return ResponseEntity.ok().body(payment);
    }
}
