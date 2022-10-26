import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += i;
        }
        return sum;
    }

    double getOrderTotal(double[] prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }

    void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + ": " + menuItems.get(i));
        }
    }

    void addCustomer(ArrayList<String> a) {
        System.out.println("Please Enter Your Name:");
        String userName = System.console().readLine();
        a.add(userName);
        System.out.println("Hello, " + userName + "! There are " + (a.size() - 1) + " people ahead of you.");
        System.out.println(a);
    }

}
