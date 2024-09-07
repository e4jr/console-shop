package Data.data_sources.cart;

import Data.models.CartItem;
import Data.models.Product;

import java.util.ArrayList;

public class MockCart extends  CartDataSource{
   private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
  public   void addCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
   public ArrayList<CartItem> getCart() {
        return cart;
    }
}
