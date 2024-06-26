package project4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project4.dto.request.OrderRequest;
import project4.dto.response.OrderReponse;
import project4.entity.Order;
import project4.service.OrderService;

import java.security.Principal;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderReponse> createOrder(@RequestBody OrderRequest request, Principal principal) {
        String username = principal.getName();
        try {
            OrderReponse response = orderService.createOrder(request, username);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log lỗi để debug
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }}
}
