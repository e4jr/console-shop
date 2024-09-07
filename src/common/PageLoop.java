package common;

import Data.comparators.AppComparator;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    int getChildrenSize(){
        return view.children.size();
    }

    int getOptionalsSize(){
        int optionSize = 0;
        if (view.nextPage) optionSize++;
        optionSize +=view.availableComparator.size();

        return  optionSize;
    }


    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run(){
        while  (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalsSize() + 1;
            try (Scanner in = new Scanner(System.in)) {
                int value = in.nextInt();
                if (value < 0 || value > fullSize) {
                    System.out.println("неверное значение страницы");
                } else if (value == fullSize) {
                    break;
                } else if (value < getChildrenSize()) {
                    AppView selectedView = view.children.get(value - 1);
                    new PageLoop(selectedView).run();
                } else {
                    if (value == getChildrenSize() + 1 && view.nextPage){
                        view.nowPage++;
                        new PageLoop(view).run();
                    }else {
                        view.nowPage = 0;
                        int indexComparator = value - getChildrenSize()- 1 - (view.nextPage ? 1 : 0);
                        view.selectComparator =  view.availableComparator.get(indexComparator);
                        new PageLoop(view).run();
                    }

                }
            }
        }
    }


   public void displayChildren(){
        int currentIndex = 1;
        System.out.println(view.title);
        System.out.println("Выберите вариант: (от 1 "+ " до " + (view.children.size()+1) +")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView view1 = view.children.get(i);
            System.out.println(currentIndex + " - "+ view1.title);
            currentIndex++;
        }

        if (view.nextPage){
            System.out.println(currentIndex + " - "+ "Следующая страница");
            currentIndex++;
        }
       for (int i = 0; i < view.availableComparator.size(); i++) {
           System.out.println(currentIndex + " - "+ view.availableComparator.get(i).name);
           currentIndex++;
       }

        System.out.println((getChildrenSize()+ getOptionalsSize()+ 1) + " - Назад");
    }
}

//20:51