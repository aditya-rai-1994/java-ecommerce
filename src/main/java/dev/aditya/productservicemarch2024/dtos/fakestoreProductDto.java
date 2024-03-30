package dev.aditya.productservicemarch2024.dtos;

import dev.aditya.productservicemarch2024.models.category;
import dev.aditya.productservicemarch2024.models.productDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakestoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;

    private double price;

    public productDetails toProduct(){
        productDetails product = new productDetails();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        category productCategory = new category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);

        return product;
    }
    public productDetails toCategory(){
        productDetails product = new productDetails();
        category productCategory = new category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);
        return product;
    }
}
