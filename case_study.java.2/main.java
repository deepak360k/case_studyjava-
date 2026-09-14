class BankAccount {
    private int balance = 10000;
    public synchronized void withdraw(String customer, int amount) {
        System.out.println(customer + " is trying to withdraw " + amount);
        if (balance >= amount) {
            System.out.println(customer + " is withdrawing " + amount);
            try {
                Thread.sleep(1000); // Simulate bank processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = balance - amount;
            System.out.println(customer + " completed withdrawal.");
            System.out.println("Remaining balance: " + balance);
        } 
        else {
            System.out.println(customer + " cannot withdraw " + amount);
            System.out.println("Insufficient balance.");
        }
    }
    public int getBalance() {
        return balance;
    }
}
class Customer extends Thread {
    private BankAccount account;
    private String customerName;
    private int amount;
    Customer(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }
    @Override
    public void run() {
        account.withdraw(customerName, amount);
    }
}
public class main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Customer c1 = new Customer(account, "Customer 1", 7000);
        Customer c2 = new Customer(account, "Customer 2", 5000);

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFinal Balance: ₹" + account.getBalance());
    }
}                                                                                                                                                                                           