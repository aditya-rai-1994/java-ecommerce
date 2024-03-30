package dev.aditya.productservicemarch2024.dtos;

import dev.aditya.productservicemarch2024.models.category;

public class categoryDto {
    private String title;
    public categoryDto() {
        // Default constructor
    }

    public categoryDto(String title) {
        this.title = title;
    }

    public category toCategory(){
        category productCategory = new category();
        productCategory.setTitle(title);
        return productCategory;
    }
}
