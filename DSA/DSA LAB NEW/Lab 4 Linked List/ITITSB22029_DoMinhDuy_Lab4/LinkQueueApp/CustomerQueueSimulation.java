import java.util.Random;

public class CustomerQueueSimulation {
    public static void main(String[] args) {
        LinkQueue customerQueue = new LinkQueue();
        Random random = new Random();

        int totalCustomers = 10; // Number of customers in the simulation
        int serveTimeMin = 1; // Minimum serve time in seconds
        int serveTimeMax = 5; // Maximum serve time in seconds

        // Simulate customers joining the queue
        for (int i = 0; i < totalCustomers; i++) {
            customerQueue.insert(i + 1); // Insert customers with IDs 1, 2, 3, etc.
            System.out.println("Customer " + (i + 1) + " joined the queue.");
        }

        // Serve customers and observe the effect on queue size
        System.out.println("\nStarting customer service simulation:");
        while (!customerQueue.isEmpty()) {
            int serveTime = serveTimeMin + random.nextInt(serveTimeMax - serveTimeMin + 1);
            System.out.println("Serving a customer for " + serveTime + " seconds...");
            try {
                Thread.sleep(serveTime * 1000L); // Simulate service time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            long servedCustomer = customerQueue.remove();
            if (servedCustomer != -1) {
                System.out.println("Customer " + servedCustomer + " has been served and removed from the queue.");
            } else {
                System.out.println("Service attempt, but customer not removed (N calls not reached).");
            }

            System.out.println("Current queue size: " + customerQueue.size());
            customerQueue.displayQueue();
        }
        System.out.println("\nAll customers have been served.");
    }
}
