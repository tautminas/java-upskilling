import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ShoeWarehouse warehouse = new ShoeWarehouse();
        Random random = new Random();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                String shoeType = ShoeWarehouse.PRODUCT_LIST
                        .get(random.nextInt(ShoeWarehouse.PRODUCT_LIST.size()));
                int quantity = random.nextInt(5) + 1;

                Order order = new Order(i, shoeType, quantity);
                warehouse.receiveOrder(order);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Runnable consumerTask = () -> {
            for (int i = 0; i < 5; i++) {
                warehouse.fulfillOrder();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread consumer1 = new Thread(consumerTask);
        Thread consumer2 = new Thread(consumerTask);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
