package oving2;

public class Account {

    //felt
    private double balance = 0.0;
    private double interestRate = 0.0;

    //konstruktør
    public Account(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        checkIfLegalArgument(balance);
        checkIfLegalArgument(interestRate);
    }

    // metoder
    public void deposit(double amount) {
    checkIfLegalArgument(amount);
    if (amount > 0) {
            balance = balance + amount;
        }
    }

    public void addInterest() {
        balance = balance + (balance * interestRate / 100);                                                      
    }

    public double getBalance() {
        return balance;
    }
                                                            
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double newInterestRate) {
        interestRate = newInterestRate;                                                             
    }

    public void withdraw(double money) {
        checkIfLegalArgument(money);
        balance = balance - money;
    }


    private void checkIfLegalArgument(double money) {
        if (money < 0 || (balance - money) < 0 || balance < 0) {
            throw new IllegalArgumentException("You either dont have enough money or the amount you want to withdraw is to small.");
        }
    }
        
    public String toString() {
        return "Account: balance = " + balance + " interest = " + interestRate;
    }

    public static void main(String[] args) {
        
        Account konto = new Account(1,5);
        System.out.println("Starttilstanden til konto er: " + konto);

        konto.setInterestRate(5);
        System.out.println("Nå med ny interestrate: " + konto);

        konto.deposit(100);
        System.out.println("Nå med satt inn 100kr: " + konto);

    }


}   
