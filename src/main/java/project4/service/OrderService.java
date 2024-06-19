package project4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.entity.Order;
import project4.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;


    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }
}
