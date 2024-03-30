package dev.aditya.productservicemarch2024.controllers;

import dev.aditya.productservicemarch2024.services.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {
    @Autowired
    private paymentService paymentService;
}
