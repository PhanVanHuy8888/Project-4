package project4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project4.dto.request.CartRequest;
import project4.dto.response.CartReponse;
import project4.entity.Cart;
import project4.service.CartService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<CartReponse> addCart(@RequestBody CartRequest request, Principal principal) {
        String username = principal.getName();
        CartReponse reponse = cartService.addCart(request, username);
        return ResponseEntity.ok(reponse);
    }
}
