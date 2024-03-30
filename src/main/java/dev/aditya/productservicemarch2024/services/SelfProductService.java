package dev.aditya.productservicemarch2024.services;

import dev.aditya.productservicemarch2024.Exception.ProductNotFoundException;
import dev.aditya.productservicemarch2024.models.category;
import dev.aditya.productservicemarch2024.models.productDetails;
import dev.aditya.productservicemarch2024.repositories.CategoryRepository;
import dev.aditya.productservicemarch2024.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    // Get single product
    @Override
    public productDetails getSingleProduct(Long productId) throws ProductNotFoundException {
        return productRepository.findByIdEquals(productId);
    }
// get all product details
    @Override
    public List<productDetails> getProducts() {
        return productRepository.findAll();
    }
// get all categories
    @Override
    public List<category> getCategories() {
       List<category> AllCategories =  categoryRepository.findAll();
       return AllCategories;
    }
// create product
    @Override
    public productDetails createProduct(String title, String description,
                                        String category, double price, String image) {
        productDetails product = new productDetails();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        category category1 = categoryRepository.findByTitle(category);
        if(category1== null){
            category newCategory = new category();
            newCategory.setTitle(category);
            category1 = newCategory;
        }
        // if the category was found in DB -> category1 will be having the id
        // else category1 will not be having any id
        product.setCategory(category1);
        productDetails savedProduct = productRepository.save(product);
        return savedProduct;
    }
// update products
    @Override
    public productDetails updateProducts(String title, String description,
                                         String category, double price,
                                         String image, Long productId) {
        productDetails prod=productRepository.findById(productId).get();
        prod.setPrice(price);
        prod.setTitle(title);
        category category1 = categoryRepository.findByTitle(category);
        if(category1== null){
            category newCategory = new category();
            newCategory.setTitle(category);
            category1 = newCategory;
        }
        // if the category was found in DB -> category1 will be having the id
        // else category1 will not be having any id
        prod.setCategory(category1);
        prod.setDescription(description);
        prod.setImageUrl(image);
        productDetails updateProducts = productRepository.save(prod);
        return updateProducts;
    }

    @Override
    public void DeleteProducts(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<productDetails> categoryProducts(String category) {
        // category categories = categoryRepository.findByTitle(category);

        return null ;
    }

}
