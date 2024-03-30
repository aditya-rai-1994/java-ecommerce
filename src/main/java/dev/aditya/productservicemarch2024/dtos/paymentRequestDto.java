package dev.aditya.productservicemarch2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class paymentRequestDto {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}
