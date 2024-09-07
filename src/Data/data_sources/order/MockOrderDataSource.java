package Data.data_sources.order;

import Data.models.Order;

public class MockOrderDataSource extends  OrderDataSource{
    private Order order;


    @Override
 public    void createOrder(Order order) {
        this.order = order;
    }

    @Override
 public    Order getOrder() {
        return order;
    }
}
