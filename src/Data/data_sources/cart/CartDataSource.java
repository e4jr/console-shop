package Data.data_sources.cart;

import Data.models.CartItem;
import Data.models.Product;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CartDataSource {
 public abstract void addCart(Product product, int count);

  public abstract ArrayList<CartItem> getCart();

}
