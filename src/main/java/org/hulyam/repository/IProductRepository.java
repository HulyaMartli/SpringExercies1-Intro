package org.hulyam.repository;

import org.hulyam.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByName(String name);
    List<Product> findAllByBrand(String brand);


}
