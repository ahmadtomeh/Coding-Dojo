import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public String getName() {
        return name;
    }

    public Order() {
        this("Guest");

    }

    public Order(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String statusMessage() {
        if (ready) {
            return "ready";
        } else {
            return "Not ready";
        }
    }

    public void display() {
        System.out.println("Customer Name: " + name);
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice() + "$");
        }
        System.out.println("Total : " + getOrderTotal());
        System.out.println(statusMessage());
        System.out.println("___________________________");

    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    }