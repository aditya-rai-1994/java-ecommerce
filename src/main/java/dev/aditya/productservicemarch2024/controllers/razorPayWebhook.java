package dev.aditya.productservicemarch2024.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebhook")
public class razorPayWebhook {
    @PostMapping("/")
    public ResponseEntity acceptWebHookRequest(){
        // redirect to UI
        return null;
    }
}
