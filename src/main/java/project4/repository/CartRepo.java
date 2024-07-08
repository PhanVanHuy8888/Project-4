package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Cart;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findCartByProductName(String productName);

    List<Cart> findByUserId(String userId);

    void deleteCartByUserId(String userId);
}
