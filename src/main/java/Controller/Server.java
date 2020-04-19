package Controller;

import Model.Person;

import java.util.ArrayList;

public class Server {
    private ArrayList<Person> loginUsers;
    private LoginManager loginManager;
    private BossManager bossManager;
    private CustomerManager customerManager;
    private SalesmanManager salesmanManager;
    private PageManager pageManager;
    private ProductPageManager productPageManager;
    private ArrayList<Product> abstractCart;

    public Server() {
        loginUsers = new ArrayList<>();
        loginManager = new LoginManager();
        bossManager = new BossManager();
        customerManager = new CustomerManager();
        salesmanManager = new SalesmanManager();
        pageManager = new PageManager();
        productPageManager = new ProductPageManager();
        abstractCart = new ArrayList<Product>();
    }
}
