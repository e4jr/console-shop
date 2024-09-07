package view;

import Data.models.CartItem;
import Data.models.Product;
import Data.service.ShopService;
import common.AppView;

import java.util.ArrayList;

public class CartView extends AppView {
    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }

   final ShopService shopService;

    @Override
    public void action() {
     ArrayList<CartItem> cart = shopService.getCart();
     for (CartItem cartItem : cart){
         System.out.println("Корзина");
         System.out.println(cartItem.product.id+" "+cartItem.product.title+" "+ cartItem.count);
     }
        System.out.println();
    }
}
