package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
