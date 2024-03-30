package dev.aditya.productservicemarch2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductRequestDto {
    private Long id;
    private String title;
    private String Description;
    private double price;
    private String imageUrl;
    private String Category;
}
