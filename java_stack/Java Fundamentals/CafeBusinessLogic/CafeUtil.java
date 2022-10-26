import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal(){
        int sum=0;
        for(int i=0;i<11;i++){
            sum+=i;
        }
        return sum;
    }
    double getOrderTotal(double[] prices){
        double sum = 0 ;
        for(double price:prices){
            sum+=price;
        }
        return sum;
    }
    
void displayMenu(ArrayList<String> menuItems){
    for(int i = 0 ; i < menuItems.size(); i++){
        System.out.println(i+": "+ menuItems.get(i));
    }
}


void addCustomer(ArrayList<String> arr){
    System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        arr.add(userName);
        System.out.println(" Hello "+userName);
        System.out.println(String.format(" There are %d people in front of you",arr.size()-1));
        System.out.println(arr);
}

}
