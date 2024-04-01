package dev.aditya.productservicemarch2024.controllers;

import com.razorpay.RazorpayException;
import dev.aditya.productservicemarch2024.dtos.paymentRequestDto;
import dev.aditya.productservicemarch2024.dtos.paymentResponse;
import dev.aditya.productservicemarch2024.services.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {
    @Autowired
    private paymentService paymentService;

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody paymentRequestDto request) throws JSONException, RazorpayException {
        return paymentService.doPayment(request.getEmail(),request.getPhoneNumber(),
                request.getAmount(),request.getOrderId());
    }
}
