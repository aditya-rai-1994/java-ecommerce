package dev.aditya.productservicemarch2024.services;

import dev.aditya.productservicemarch2024.Exception.ProductNotFoundException;
import dev.aditya.productservicemarch2024.models.category;
import dev.aditya.productservicemarch2024.models.productDetails;

import java.util.List;

public interface ProductService {
    // Single Product
productDetails getSingleProduct(Long productId) throws ProductNotFoundException;
// all products
List<productDetails> getProducts();
// All categories
List<category>getCategories();
// create product
productDetails createProduct(String title, String description,
                             String category, double price,
                             String image);
// update product
productDetails updateProducts(String title, String description,
                              String category, double price,
                              String image, Long productId);
// Delete Products
void DeleteProducts(Long productId);
// Get product from category
List<productDetails> categoryProducts(String category);
}
