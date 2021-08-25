package com.github.matheusmv.hrpayroll.services;

import com.github.matheusmv.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(final long workerId, final int days) {
        return new Payment("Bob", 200.0, days);
    }
}
