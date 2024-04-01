package dev.aditya.productservicemarch2024.services;

import com.razorpay.RazorpayException;
import dev.aditya.productservicemarch2024.dtos.paymentResponse;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface paymentService {
    String doPayment(String email, String phone, Long amount, String orderId) throws JSONException, RazorpayException;
}
