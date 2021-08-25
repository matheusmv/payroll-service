package com.github.matheusmv.hrpayroll.resources;

import com.github.matheusmv.hrpayroll.entities.Payment;
import com.github.matheusmv.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentResource {

    private final PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
                                              @PathVariable Integer days) {
        return service
                .getPayment(workerId, days)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
