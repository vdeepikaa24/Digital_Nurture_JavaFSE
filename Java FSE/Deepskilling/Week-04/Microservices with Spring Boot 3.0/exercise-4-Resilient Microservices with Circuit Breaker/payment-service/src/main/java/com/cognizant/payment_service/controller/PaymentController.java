package com.cognizant.payment_service.controller;



import com.cognizant.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/charge")
    public String processPayment(
            @RequestBody String paymentDetails,
            @RequestParam(value = "simulateDelay", defaultValue = "false") boolean simulateDelay) {
        return paymentService.executeExternalPayment(paymentDetails, simulateDelay);
    }
}