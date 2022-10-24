public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready, ";
        String displayTotalMessage = ", Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 4.5;
        double cappuccinoPrice = 5.0;
    
        // Customer name variables (add yours below) Sam, Jimmy and Noah,
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        if (isReadyOrder1){
            System.out.println(generalGreeting + customer1 + readyMessage + displayTotalMessage + mochaPrice); // Displays "Welcome to Cafe Java, Cindhuri"
        }
        else{
            System.out.println(generalGreeting + customer1 + pendingMessage);
        }
        
        if (isReadyOrder4){
            System.out.println(generalGreeting + customer4 + readyMessage + displayTotalMessage + cappuccinoPrice);
        }
        else{
            System.out.println(generalGreeting + customer4 + pendingMessage);
        }

        if(isReadyOrder2){
            System.out.println(generalGreeting + customer2 + displayTotalMessage + lattePrice *2);
        }
        else{
            System.out.println(generalGreeting + customer2 + readyMessage);
        }

        System.out.println(generalGreeting + customer3 + displayTotalMessage + (lattePrice - dripCoffeePrice));
    	// ** Your customer interaction print statements will go here ** //
    }
}
