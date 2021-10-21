package br.com.waldecleber.shoppingcart.controller;

import br.com.waldecleber.shoppingcart.model.Cart;
import br.com.waldecleber.shoppingcart.model.Item;
import br.com.waldecleber.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Cart cart;
        Optional<Cart> loadedCart = findById(id);
        if (loadedCart.isPresent()) {
            cart = loadedCart.get();
        } else {
            cart = Cart.builder().id(id).build();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Integer id) {
        if (findById(id).isPresent()) {
            cartRepository.deleteById(id);
        }
    }


}
