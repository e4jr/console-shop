package Data.service;

import Data.data_sources.cart.CartDataSource;
import Data.data_sources.catalog.CatalogDataSource;
import Data.data_sources.order.OrderDataSource;
import Data.models.CartItem;
import Data.models.Order;
import Data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    final CartDataSource cartDataSource;
    final CatalogDataSource catalogDataSource;
    final OrderDataSource orderDataSource;

    public ShopService( CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.cartDataSource = cartDataSource;
        this.catalogDataSource = catalogDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog(int page, int limit){
       return catalogDataSource.getCatalog(page, limit);
    }

    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator){
       return catalogDataSource.getCatalog(page, limit, comparator);
    }

  public boolean addToCart(String productId, int count){
      ArrayList<Product> catalog = getCatalog(0, 10);
      for (Product product : catalog){
          System.out.println(product.id+" "+product.title+" "+ product.price);
      }
      System.out.println();
      return  false;
  }



    public ArrayList<CartItem> getCart(){
       return cartDataSource.getCart();
    }


    public  void createOrder(String name, String phone, String address, String paymentType, String deliveryTime){
        ArrayList<CartItem> cart =  getCart();
        Order newOrder = new Order(name,phone,address,paymentType,deliveryTime, cart);
        orderDataSource.createOrder(newOrder);
    }
}
