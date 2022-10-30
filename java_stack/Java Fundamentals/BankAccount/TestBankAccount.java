public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(0.0 , 0.0);
        BankAccount acc2 = new BankAccount(0.0 , 50.0);
        
        System.out.println(BankAccount.getNumOfAccount());
        System.out.println(acc1.getCheckingBalance());

        System.out.println(acc1.addMoney("check", 50));
        System.out.println(acc1.withdrawMoney("save", 100));
        System.out.println(acc1.displayTotal());
        System.out.println("----------------------");
        System.out.println(acc2.addMoney("check", 50));
        System.out.println(acc2.withdrawMoney("check", 200));
    }
}
