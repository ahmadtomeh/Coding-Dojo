class BankAccount:
    def __init__(self, intRate = 0.02, balance = 0):
        self.intRate = intRate
        self.account_balance = balance
        
    def deposit(self, balance):
        self.account_balance += balance
        return self
    def withdraw(self, balance):
        self.account_balance -= balance
        return self
    def display_account_info(self):
        print(self.intRate, self.account_balance)
    
    def yield_interest(self):
        self.account_balance=self.account_balance*self.intRate+ self.account_balance
        return self

class User:
    def __init__(self, name, email, intRate, amount):
        self.name = name
        self.email = email
        self.intRate = intRate
        self.account_balance = BankAccount(intRate= intRate, balance= amount)
    
    def make_deposit(self, amount):
        self.account_balance.deposit(amount)
        
    def make_withdrawal(self, amount):
        self.account_balance.withdraw(amount)

    def display_user_balance(self):
        print("User:", self.name,", Balance: $", self.account_balance.account_balance)
    
    def interest(self):
        self.account_balance.account_balance =self.account_balance.account_balance * self.intRate + self.account_balance.account_balance
        
        
haneen = User("haneen", "haneen@python.com",0.03 , 700)
ahmad = User("ahmad", "ahmad@python.com",0.2 , 500)
thabet = User("thabet", "thabet@python.com",0.3 , 300)

haneen.make_deposit(100)
haneen.make_withdrawal(50)
haneen.interest()
haneen.display_user_balance()

