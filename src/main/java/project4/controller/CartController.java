package project4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project4.dto.request.CartRequest;
import project4.dto.response.CartReponse;
import project4.entity.Cart;
import project4.repository.UserRepo;
import project4.service.CartService;
import project4.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserRepo userRepo;


    @PostMapping("/addCart")
    public ResponseEntity<CartReponse> addCart(@RequestBody CartRequest request, Principal principal) {
        String username = principal.getName();
        String userId = userRepo.findIdByUserName(username);
        CartReponse reponse = cartService.addCart(request, userId);
        return ResponseEntity.ok(reponse);
    }

    @GetMapping("/listCart")
    public List<Cart> getAll(Principal principal){
        String username = principal.getName();
        String userId = userRepo.findIdByUserName(username);
        return cartService.getCartByUserId(userId);
    }

}
