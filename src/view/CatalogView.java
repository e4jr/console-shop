package view;

import Data.comparators.AppComparator;
import Data.comparators.PriceComparator;
import Data.models.Product;
import Data.service.ShopService;
import common.AppView;
import common.Pagination;

import java.util.ArrayList;
import java.util.Comparator;

public class CatalogView extends AppView implements Pagination {
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparator.addAll(comparators);
        if (!availableComparator.isEmpty()){
            selectComparator =  availableComparator.get(0);
        }
    }

   final ShopService shopService;

    @Override
    public void action() {
        PriceComparator comparator =  new PriceComparator();
        comparator.isAsc = false;
     ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectComparator.comparator);
    nextPage = catalog.size() == pageLimit;
     for (Product product : catalog){
         System.out.println(product.id+" "+product.title+" "+ product.price);
     }
        System.out.println();
    }
}
