class Theatre {
    private boolean[] seats = new boolean[5];
    public synchronized void bookSeats(String customer, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 5) {
            System.out.println(customer + ": Invalid seat number");
            return;
        }

        if (!seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true;

            System.out.println(customer + " booked Seat " + seatNumber);
        } else {
            System.out.println(customer + ": Seat " + seatNumber + " is already booked");
        }
    }
}

class Customer extends Thread {
    private Theatre theatre;
    private String customerName;
    private int seatNumber;

    Customer(Theatre theatre, String customerName, int seatNumber) {
        this.theatre = theatre;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public void run() {
        theatre.bookSeats(customerName, seatNumber);
    }
}

public class online{
    public static void main(String[] args) {

        Theatre theatre = new Theatre();

        Customer c1 = new Customer(theatre, "Customer 1", 2);
        Customer c2 = new Customer(theatre, "Customer 2", 2);
        Customer c3 = new Customer(theatre, "Customer 4", 4);

        c1.start();
        c2.start();
        c3.start();
    }
}