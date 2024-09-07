package view;

import Data.service.ShopService;
import common.AppView;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {

    public AddToCartView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService= shopService;
    }

   final ShopService shopService;

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID продукта");
        String productId = scanner.nextLine();
        if (productId == null) return;
        System.out.println("Выберите количество");
       int count  = scanner.nextInt();
      final boolean res =  shopService.addToCart(productId, count);
      if (res){
          System.out.println("Товар добавлен");
      }else {
          System.out.println("Не удалось добавить товар");
      }

    }
}
