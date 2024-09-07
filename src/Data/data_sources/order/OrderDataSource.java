package Data.data_sources.order;

import Data.models.CartItem;
import Data.models.Order;

import java.util.ArrayList;

public abstract class OrderDataSource {

  public abstract void createOrder(Order order);
  public abstract Order getOrder();

}
