package dev.aditya.productservicemarch2024.controllers;

import dev.aditya.productservicemarch2024.Exception.ProductNotFoundException;
import dev.aditya.productservicemarch2024.dtos.createProductRequestDto;
import dev.aditya.productservicemarch2024.models.category;
import dev.aditya.productservicemarch2024.models.productDetails;
import dev.aditya.productservicemarch2024.services.ProductService;
import dev.aditya.productservicemarch2024.services.fakeStoreProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    private ProductService productService;
    public productController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }
    // Create products
    @PostMapping("/products")
    public productDetails createProducts(@RequestBody createProductRequestDto request){
        return productService.createProduct(request.getTitle(),
                request.getDescription(), request.getCategory(), request.getPrice(), request.getImageUrl()
        );
    }
    // Get single product
    @GetMapping("/products/{id}")
    public productDetails getProductDetails(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getSingleProduct(productId);
    }

    // get all products
    @GetMapping("/products")
    public List<productDetails> getAllProducts(){
        return productService.getProducts();
    }

    // get categories
    @GetMapping("/products/categories")
    public List<category> getCategories(){
        return productService.getCategories();
    }

    // update product
    @PutMapping("/products/{id}")
    public <productId> productDetails updateProduct(@RequestBody createProductRequestDto request, @PathVariable("id") Long productId){
        return productService.updateProducts(request.getTitle(),
                request.getDescription(), request.getCategory(), request.getPrice(), request.getImageUrl(),productId);
    }
    // Delete Product
    @DeleteMapping("/products/{Id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {

        productService.DeleteProducts(productId);
        String deleteResponse = "Product with id : " + productId + " is deleted";
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }
    // Get Product in specific category
    @GetMapping("/products/category/{category}")
    public List<productDetails> categoryProduct(@PathVariable("category") String category){
        return productService.categoryProducts(category);
    }
}
