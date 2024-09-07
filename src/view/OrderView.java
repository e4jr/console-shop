package view;

import Data.models.Product;
import Data.service.ShopService;
import common.AppView;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    public OrderView(ShopService shopService ) {
        super("Оформить заказ", new ArrayList<>());
        this.shopService = shopService;
    }

   final ShopService shopService;

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String name =  scanner.nextLine();
        System.out.println("Введите свой телефон");
        String phone =  scanner.nextLine();
        System.out.println("Введите адрес доставки");
        String address =  scanner.nextLine();
        System.out.println("Выберите оплату");
        System.out.println("наличными/картой");
        String cash =  scanner.nextLine();
        if (cash.equals("наличными")){
            cash = "оплата наличными";
        }else if (cash.equals("картой")) {
           cash = "оплата картой";
            System.out.println("Введите номер карты");
            String card = scanner.nextLine();
        }else {
            System.out.println("Укажите вариант оплаты ");
        }

        System.out.println("Выберите дату доставки");
        String date =  scanner.nextLine();
        System.out.println("Заказ оформлен!");

     shopService.createOrder(name, phone,address, cash, date );
    }
}
