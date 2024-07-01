import java.util.ArrayList;

class Order {
    private int id;
    private ArrayList<Item> items;

    // Constructor
    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // Method to add an item to the order
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to calculate the average cost of items in the order
    public double calculateAverageCost() {
        if (items.isEmpty()) {
            return 0;
        }

        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getPrice();
        }
        return totalCost / items.size();
    }
}
