package Data.data_sources.catalog;

import Data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockCatalogDataSourceImpl extends CatalogDataSource{

    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream =  products.stream().filter(p->p.available).sorted(comparator).skip((long) page*limit).limit(limit);
        return new ArrayList<>(productStream.collect(Collectors.toList()));

    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream =  products.stream().filter(p->p.available).skip((long) page*limit).limit(limit);
        return new ArrayList<>(productStream.collect(Collectors.toList()));
    }

    @Override
    public Product productById(String id) {
        ArrayList<Product> products = getCatalog(0, 99999999);
      for (Product p : products){
          if (p.id.equals(id)) {
              return  p;
          }
      }
        return null;
    }

    ArrayList<Product> generateProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "Smart Phone", "Best smart phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Best laptop", 2000, true));
        products.add(new Product("id3", "Watch", "Best watch", 500, true));
        products.add(new Product("id4", "Phone", "Simple phone", 100, true));
        for (int i = 0; i < 20; i++) {
            products.add(new Product("id"+(i+5),"IPhone" + i, "Smart phone", 100 + i + 100, i % 4 !=0));
        }

        return products;


    }

}
