package com.example.CartService.controller;

import com.example.CartService.model.Cart;
import com.example.CartService.model.DeliveryDetails;
import com.example.CartService.repository.DeliveryRepository;
import com.example.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    //adding item to cart
    @PostMapping("/addItem/{productId}")
    public String saveItem(@PathVariable int productId){
       cartService.addToCart(productId);
       return "item added";
    }
    // editing cart details(quantity)
    @PutMapping("/editItem")
    public String updateCart(@RequestBody Cart cart){
        cartService.updateCartQuantity(cart);
        return "cart updated";
    }
    //showing items in cart
    @GetMapping("/findAllItems")
    public List<Cart> getItems(){
        return cartService.getAllItems();
    }
    //getting item by cartId
    @GetMapping("/getItemByCartId/{cartId}")
    public Optional<Cart> getItemByCartId(@PathVariable int cartId){
        return  cartService.getItemByCartId(cartId);
    }
    //deleting item in cart
    @DeleteMapping("/delete/{cartId}")
    public String deleteItem(@PathVariable int cartId){
       cartService.deleteItem(cartId);
        return "product deleted with id :"+ cartId;
    }
    //adding address

    //adding payment

    //complete order






}
