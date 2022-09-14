class User:
    def __init__(self, name, email, amount):
        self.name = name
        self.email = email
        self.account_balance = amount
#--Withdrawal
    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self
#--display_user_balance
    def display_user_balance(self):
        print("User:", self.name,", Balance: $ ", self.account_balance)
#--Transfer
    def transfer_mony(self, other_user, amount):
        other_user.account_balance += amount
        self.account_balance -= amount
        return self
#--Deposit
    def make_deposit(self, amount):
        self.account_balance += amount
        return self
        
#--------------------------------------------------------------------------

haneen = User("haneen", "haneen@python.com", 1000)
ahmad = User("ahmad", "ahmad@python.com", 500)
thabet = User("thabet", "thabet@python.com", 300)

#Have the first user make 3 deposits and 1 withdrawal and then display their balance
haneen.make_deposit(100).make_deposit(50).make_deposit(350).make_withdrawal(100).display_user_balance()

#Have the second user make 2 deposits and 2 withdrawals and then display their balance
ahmad.make_deposit(150).make_deposit(50).make_withdrawal(100).display_user_balance()

#Have the third user make 1 deposits and 3 withdrawals and then display their balance
thabet.make_deposit(200).make_withdrawal(150).make_withdrawal(50).make_withdrawal(150).display_user_balance()

#BONUS: Add a transfer_money method; have the first user transfer money to the third user and then print both users' balances
haneen.transfer_mony(thabet,150).display_user_balance()
thabet.display_user_balance()