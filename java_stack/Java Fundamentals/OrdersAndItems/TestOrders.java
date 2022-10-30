import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        Item item1 = new Item("mocha", 3);
        Item item2 = new Item("latte", 4);
        Item item3 = new Item("drip coffee", 2);
        Item item4 = new Item("cappuccino", 5);

        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("sam");
        Order order5 = new Order();
        Order order6 = new Order();

        order1.addItem(item1);
        order1.addItem(item3);
        order1.addItem(item2);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item4);
        order3.addItem(item1);
        order3.addItem(item3);
        order4.addItem(item4);
        order4.addItem(item2);
        order5.addItem(item1);
        order5.addItem(item2);
        order6.addItem(item3);
        order6.addItem(item4);
        order1.setReady(true);
        order2.setReady(true);
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
        order6.display();
    }
}
