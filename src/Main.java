import Data.comparators.AppComparator;
import Data.comparators.PriceComparator;
import Data.data_sources.cart.CartDataSource;
import Data.data_sources.cart.MockCart;
import Data.data_sources.catalog.CatalogDataSource;
import Data.data_sources.catalog.MockCatalogDataSourceImpl;
import Data.data_sources.order.MockOrderDataSource;
import Data.data_sources.order.OrderDataSource;
import Data.models.Product;
import Data.service.ShopService;
import common.AppView;
import common.PageLoop;
import view.*;

import java.security.Provider;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource =  new MockCart();
        CatalogDataSource catalogDataSource =  new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource =  new MockOrderDataSource();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> catalogComparator =  new ArrayList<>();
        catalogComparator.add(new AppComparator<>(new PriceComparator(true), "по возрастанию цены"));
        catalogComparator.add(new AppComparator<>(new PriceComparator(false), "по убыванию цены"));
        AppView catalogView = new CatalogView(shopService, catalogChildren, catalogComparator);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren =  new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();
    }
}