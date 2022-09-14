class BankAccount:                                    #Create a BankAccount class with the attributes interest rate and balance
    def __init__(self, int_rate, balance):           #Add a deposit method to the BankAccount class
        self.int_rate = int_rate
        self.account_balance = balance
    def deposit(self, balance):
        self.account_balance += balance
        return self
    def withdraw(self, balance):                     #Add a withdraw method to the BankAccount class
        self.account_balance -= balance
        return self
    def display_account_info(self):                  #Add a display_account_info method to the BankAccount class
        print(self.int_rate, self.account_balance)
    def yield_interest(self):                        #Add a yield_interest method to the BankAccount class
        self.account_balance=self.account_balance*self.int_rate+ self.account_balance
        return self
        
#Create 2 accounts
ahmad = BankAccount(0.01, 200)
thabet = BankAccount(0.05, 500)

#To the first account, make 3 deposits and 1 withdrawal
#then yield interest and display the account's info all in one line of code.
ahmad.deposit(1000).deposit(500).deposit(300).withdraw(500).yield_interest().display_account_info()

#To the first account, make 3 deposits and 1 withdrawal
#then yield interest and display the account's info all in one line of code.
thabet.deposit(500).deposit(1000).withdraw(50).withdraw(100).withdraw(150).withdraw(200).yield_interest().display_account_info()