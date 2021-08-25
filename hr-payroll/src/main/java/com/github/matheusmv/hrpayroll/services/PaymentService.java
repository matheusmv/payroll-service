package com.github.matheusmv.hrpayroll.services;

import com.github.matheusmv.hrpayroll.entities.Payment;
import com.github.matheusmv.hrpayroll.feignclients.WorkerFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Optional<Payment> getPayment(final long workerId, final int days) {
        try {
            var worker = workerFeignClient.getById(workerId).getBody();

            return Optional.of(new Payment(worker.getName(), worker.getDailyIncome(), days));
        } catch (FeignException exception) {
            return Optional.empty();
        }
    }
}
