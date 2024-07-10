package project4.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project4.dto.request.OrderDetailRequest;
import project4.dto.request.OrderRequest;
import project4.dto.response.OrderReponse;
import project4.entity.Order;
import project4.entity.OrderDetail;
import project4.entity.Product;
import project4.mapper.OrderMapper;
import project4.repository.CartRepo;
import project4.repository.OrderRepo;
import project4.repository.ProductRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;
    private final OrderMapper orderMapper;
    private final ProductRepo productRepo;

    @Transactional
    public OrderReponse createOrder(OrderRequest request, String userId) {
        Order orders = orderMapper.createOrder(request);
        orders.setCreateDate(new Date());
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        orders.setCode("Chocolate_" + randomNum);
        orders.setStatus("PENDING");
        orders.setPayment("COD");

        List<OrderDetail> orderDetails = new ArrayList<>();

        for (OrderDetailRequest detailRequest : request.getOrderDetails()) {
            int productId = productRepo.findIdByName(detailRequest.getProductName());
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product Id invalid"));
            OrderDetail detail = new OrderDetail();
            detail.setTotal(detailRequest.getPrice() * detailRequest.getQuantity());
            detail.setProduct(product);
            detail.setOrder(orders);
            detail.setQuantity(detailRequest.getQuantity());
            detail.setPrice(detailRequest.getPrice());
            orderDetails.add(detail);
        }

        orders.setOrderDetails(orderDetails);
        orderRepo.save(orders);
        log.info("Save order successfully");
        cartRepo.deleteCartByUserId(userId);
        return OrderReponse.builder().build();
    }

    public List<OrderReponse> getAll() {

        return  orderRepo.findAll().stream().map(orderMapper::toOrder).toList();
    }
}

