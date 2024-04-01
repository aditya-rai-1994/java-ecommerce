package dev.aditya.productservicemarch2024.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import dev.aditya.productservicemarch2024.dtos.paymentResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class paymentServiceImpl implements paymentService{
    private RazorpayClient razorpayClient;
     public paymentServiceImpl(RazorpayClient razorpayClient){
         this.razorpayClient = razorpayClient;
     }

    @Override
    public String doPayment(String email, String phone, Long amount, String orderId) throws RazorpayException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("receipt", orderId);

            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("phone", phone);
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);

            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "https://domain.com/razorpayWebHook");
            paymentLinkRequest.put("callback_method", "post");

            PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
