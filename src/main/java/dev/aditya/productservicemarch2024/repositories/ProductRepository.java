package dev.aditya.productservicemarch2024.repositories;

import dev.aditya.productservicemarch2024.models.productDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<productDetails,Long> {
    productDetails save(productDetails p);

    @Override
    List<productDetails> findAll();
    // List<productDetails> findAllByCategoryTitle(String category);
    productDetails findByIdEquals(Long ID);
    void deleteById(Long Id);
}
