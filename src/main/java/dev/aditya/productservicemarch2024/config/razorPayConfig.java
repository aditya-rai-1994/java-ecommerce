package dev.aditya.productservicemarch2024.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class razorPayConfig {
    @Value("${razorpay.Key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeyValue;
@Bean
    public RazorpayClient createRazorpayClient()throws RazorpayException{
        return new RazorpayClient(razorpayKeyId, razorpayKeyValue);
    }
}
