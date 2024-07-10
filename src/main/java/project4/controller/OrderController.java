package project4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project4.dto.request.OrderRequest;
import project4.dto.response.OrderReponse;
import project4.entity.Order;
import project4.repository.UserRepo;
import project4.service.OrderService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserRepo userRepo;

    @PostMapping
    public ResponseEntity<OrderReponse> createOrder(@RequestBody OrderRequest request, Principal principal) {
        String username = principal.getName();
        String userId = userRepo.findIdByUserName(username);
        try {
            OrderReponse response = orderService.createOrder(request, userId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log lỗi để debug
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list")
    public List<OrderReponse> getAll() {
        return orderService.getAll();
    }
}
