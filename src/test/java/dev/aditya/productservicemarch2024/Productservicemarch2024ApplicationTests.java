package dev.aditya.productservicemarch2024;

import dev.aditya.productservicemarch2024.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Productservicemarch2024ApplicationTests {
@Autowired
private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void testingQueries(){
        productRepository.findByIdEquals(2L);

    }

}
