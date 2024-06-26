package project4.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.dto.request.OrderRequest;
import project4.dto.response.OrderReponse;
import project4.entity.Order;
import project4.mapper.OrderMapper;
import project4.repository.CartRepo;
import project4.repository.OrderRepo;

import java.util.Date;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderReponse createOrder(OrderRequest request, String username) {
        Order orders = orderMapper.createOrder(request);
        orders.setCreateDate(new Date());
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        orders.setCode("Chocolate_" + randomNum);
        orders.setStatus("PENDING");
        orders.setPayment("COD");

        orderRepo.save(orders);
        cartRepo.deleteCartByUsername(username);
        return OrderReponse.builder().build();
    }
}
