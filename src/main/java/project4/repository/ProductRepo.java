package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
