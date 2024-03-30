package dev.aditya.productservicemarch2024.services;

import dev.aditya.productservicemarch2024.Exception.ProductNotFoundException;
import dev.aditya.productservicemarch2024.dtos.categoryDto;
import dev.aditya.productservicemarch2024.dtos.fakestoreProductDto;
import dev.aditya.productservicemarch2024.models.category;
import dev.aditya.productservicemarch2024.models.productDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public productDetails getSingleProduct(Long productId) throws ProductNotFoundException {

        ResponseEntity<fakestoreProductDto> fakeStoreProductResponse = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,fakestoreProductDto.class);

        fakestoreProductDto fakeStoreProduct = fakeStoreProductResponse.getBody();
        if(fakeStoreProduct== null){
            throw new ProductNotFoundException("product with id: "+ productId + "doesn't exist. Retry some other product");
        }
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<productDetails> getProducts() {

        fakestoreProductDto[] fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products",
                fakestoreProductDto[].class);
        List<productDetails> products = new ArrayList<>();
        for(fakestoreProductDto fakeStoreProducts: fakeStoreProduct){
            products.add(fakeStoreProducts.toProduct());
        }
        return products;
    }

    @Override
    public List<category> getCategories() {
        categoryDto[] categories=restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                categoryDto[].class);
        List<category> categories1 = new ArrayList<>();
        for(categoryDto allCategories: categories){
            categories1.add(allCategories.toCategory());
        }
        return categories1;
    }


    @Override
    public productDetails createProduct(String title, String description, String category, double price, String image) {
        fakestoreProductDto fakeStoreProductDto = new fakestoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakestoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",fakeStoreProductDto,fakestoreProductDto.class);
        return response.toProduct();
    }

    @Override
    public productDetails updateProducts(String title,String description, String category, double price, String image, Long productId)  {
        fakestoreProductDto fakeStoreProductDto = new fakestoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        HttpEntity<fakestoreProductDto> requestEntity = new HttpEntity<>(fakeStoreProductDto);
        ResponseEntity<fakestoreProductDto>response = restTemplate.exchange("https://fakestoreapi.com/products/"+productId,HttpMethod.PUT,
                 requestEntity,fakestoreProductDto.class);
        fakestoreProductDto fakeStoreProduct = response.getBody();
        return fakeStoreProduct.toProduct();
    }
// Delete Products
    @Override
    public void DeleteProducts(Long productId) {
        String apiUrl = "https://fakestoreapi.com/products/" + productId;
        restTemplate.delete(apiUrl);
    }
// Get product from category
    @Override
    public List<productDetails> categoryProducts(String category) {
        fakestoreProductDto[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + category,
                fakestoreProductDto[].class);
        List<productDetails> products = new ArrayList<>();
        for(fakestoreProductDto fakeStoreProduct:fakeStoreProducts){
            products.add(fakeStoreProduct.toProduct());
        }
        return products;
    }
}

