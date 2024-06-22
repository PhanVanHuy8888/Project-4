package project4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.dto.request.CartRequest;
import project4.dto.response.CartReponse;
import project4.entity.Cart;
import project4.mapper.CartMapper;
import project4.repository.CartRepo;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public CartReponse addCart(CartRequest request, String username) {
        Cart cart = cartRepo.findByUsernameAndProductName(username, request.getProductName());
        if (cart != null) {
            cart.setQuantity(cart.getQuantity() + request.getQuantity());
            cart.setSum(cart.getQuantity() * request.getPrice());
        } else {
            cart = new Cart();
            cart.setUsername(username);
            cart.setProductName(request.getProductName());
            cart.setQuantity(request.getQuantity());
            cart.setPrice(request.getPrice());
            cart.setSum(request.getQuantity() * request.getPrice());

        }

        cartRepo.save(cart);

        return CartReponse.builder()
                .status("Success")
                .message("Product add to cart Success!")
                .build();
    }
}