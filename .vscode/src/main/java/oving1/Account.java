package oving1;

public class Account {

    private double balance = 0.0;
    private double interestRate = 0.0;

    public void deposit(double amount) {
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

        
    public String toString() {
        return "Account: balance = " + balance + " interest = " + interestRate;
    }

    public static void main(String[] args) {
        
        Account konto = new Account();
        System.out.println("Starttilstanden til konto er: " + konto);

        konto.setInterestRate(5);
        System.out.println("Nå med ny interestrate: " + konto);

        konto.deposit(100);
        System.out.println("Nå med satt inn 100kr: " + konto);

    }


}   
