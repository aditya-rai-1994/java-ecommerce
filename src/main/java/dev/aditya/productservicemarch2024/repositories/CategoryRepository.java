package dev.aditya.productservicemarch2024.repositories;

import dev.aditya.productservicemarch2024.models.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<category, Long> {
    category findByTitle(String title);

    @Override
    List<category> findAll();

    category save(category category);
}
