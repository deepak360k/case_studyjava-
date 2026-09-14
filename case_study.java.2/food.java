class FoodPreparation extends Thread {
    public void run() {
        System.out.println("Food preparation started...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Food preparation completed!");
    }
}

class FoodDelivery extends Thread {
    public void run() {
        System.out.println("Food delivery started...");
        System.out.println("Food delivered successfully!");
    }
}

public class food{
    public static void main(String[] args) {
        
        FoodPreparation preparation = new FoodPreparation();
        FoodDelivery delivery = new FoodDelivery();

        // Start food preparation
        preparation.start();

        try {
            // Wait until food preparation is completed
            preparation.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        delivery.start();
    }
}