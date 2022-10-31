public class TestOrders {
    public static void main(String[] args) {
        Item item1 = new Item("mocha", 3);
        Item item2 = new Item("latte", 4);
        Item item3 = new Item("drip coffee", 2);
        Item item4 = new Item("cappuccino", 5);
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem(item1);
        kiosk.addMenuItem(item2);
        kiosk.addMenuItem(item3);
        kiosk.addMenuItem(item4);
        kiosk.newOrder();
    }
}
