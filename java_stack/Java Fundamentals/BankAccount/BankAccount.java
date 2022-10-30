public class BankAccount {
    private double checkingBalance ;
    private double savingsBalance ;
    private double total ;
    private static int numOfAccount = 0;

    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.numOfAccount ++;
    }

    public static int getNumOfAccount(){
        return numOfAccount;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public String addMoney(String type, double amount){
        if(type == "check"){
            checkingBalance += amount;
        }
        else if(type == "save"){
            savingsBalance += amount;

        }
        return "Your Checing Balance = " + checkingBalance + "\nYour Savings Balance = " + savingsBalance +"\n" + displayTotal();
    }
    
    public String withdrawMoney(String type, double num){
        if(type == "check"){
            if (checkingBalance >= num){
                checkingBalance -= num;
            }
            else{
                return "The checking balance is not enough to perform this operation : " + num;
            }
        }
        else if(type == "save"){
            if(savingsBalance >= num){
                savingsBalance -= num;
            }
            else{
                return "The savings balance is not enough to perform this operation : " + num;
            }
        }
        return "Your Checking Balance = " + checkingBalance + "\nYour savings Balance = " + savingsBalance +"\n" + total;
    }

    public String displayTotal(){
        this.total = this.savingsBalance + this.checkingBalance ;
        return "Total : " + this.total;
    }
}
