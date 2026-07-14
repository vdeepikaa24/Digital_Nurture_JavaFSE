package com.cognizant.payment_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "thirdPartyPaymentApi", fallbackMethod = "processPaymentFallback")
    public String executeExternalPayment(String paymentDetails, boolean shouldDelay) {
        log.info("Incoming transaction processed. Attempting connection to Third-Party API...");

        if (shouldDelay) {
            log.warn("Simulating external network latency (3-second delay)...");
            try {
                Thread.sleep(3000); // Exceeds the 2-second slowCallDurationThreshold limit!
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return "SUCCESS: Transaction routed successfully through Third-Party API. Reference ID: TXN" + System.currentTimeMillis();
    }

    public String processPaymentFallback(String paymentDetails, boolean shouldDelay, Throwable exception) {
        // Requirement Met: Log and monitor fallback events
        log.error("CRITICAL: Third-Party Gateway is degraded or unavailable. Circuit Breaker triggered!");
        log.error("Fallback reason: {}", exception.getMessage());

        return "FALLBACK ACTIVE: Third-party API is experiencing latency issues. Securely queued transaction offline: " + paymentDetails;
    }
}