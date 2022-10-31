import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private int numOfItems = 0;

    public void addMenuItem(Item item) {
        menu.add(item);
        item.setIndex(numOfItems);
        numOfItems++;
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + "-- $" + item.getPrice());
        }
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order newO = new Order(name);
        displayMenu();
        
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        while (!itemNumber.equals("q")) {
            displayMenu();
            for (Item item : menu) {
                if (item.getIndex() == Integer.parseInt(itemNumber)) {
                    newO.addItem(item);
                }
            }
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        newO.display();
    }
}