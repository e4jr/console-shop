package common;

import Data.comparators.AppComparator;
import Data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public  int  nowPage = 0;
    public boolean  nextPage = false;
    public AppComparator<Product> selectComparator;
    public final ArrayList<AppComparator> availableComparator = new ArrayList<>();

    protected AppView(String title, ArrayList<AppView> children ) {
        this.title = title;
        this.children = children;
    }

  public void action(){

    }
}
