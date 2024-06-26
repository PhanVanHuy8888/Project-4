package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Cart;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findByUsernameAndProductName(String username, String productName);

    List<Cart> findByUsername(String username);

    void deleteCartByUsername(String username);
}
