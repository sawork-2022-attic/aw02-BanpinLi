package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }

    // 清空购物车
    @ShellMethod(value = "Empty Cart", key = "e")
    public String emptyCart() {
        posService.newCart();
        return "Empty Cart OK.";
    }

    // 改变购物车中的商品数量
    @ShellMethod(value = "Modify Cart", key = "m")
    public String modifyCart(String productId, int amount) {
        if(posService.modify(productId, amount)) {
            return posService.getCart().toString();
        }
        return "Error";
    }

    // 查看当前购物车购物状态
    @ShellMethod(value = "View Cart", key = "v")
    public String viewCart() {
        Cart cart = posService.getCart();
        if(cart != null) {
            return cart.toString();
        }
        return "No cart, Please create an empty cart.";
    }

    // 删除商品
    @ShellMethod(value = "Delete Cart Item", key = "d")
    public String deleteCartItem(String productId) {
        if(posService.remove(productId)) {
            return posService.getCart().toString();
        }
        return "Error";
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }
}
