package com.github.matheusmv.hrpayroll.services;

import com.github.matheusmv.hrpayroll.entities.Payment;
import com.github.matheusmv.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(final long workerId, final int days) {
        final String url = workerHost + "/workers/" + workerId;

        var worker = restTemplate.getForObject(url, Worker.class);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
