package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project4.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p.id FROM Product p WHERE p.name = ?1")
    int findIdByName(String name);

    @Query("SELECT p.price FROM Product p WHERE p.name = ?1")
    float findPriceByName(String name);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> findByName(String name);
}
