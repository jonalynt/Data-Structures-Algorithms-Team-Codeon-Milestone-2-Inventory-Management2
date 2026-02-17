import java.util.*;

public class Inventory {
    private final TreeMap<String, List<Item>> stockByBrand = new TreeMap<>();

    public static class Item {
        private final String engineNumber;
        private final String model; // optional metadata
        public Item(String engineNumber, String model) {
            this.engineNumber = engineNumber;
            this.model = model;
        }
        public String getEngineNumber() { return engineNumber; }
        public String getModel() { return model; }
    }

    // Add new stock
    public void addStock(String brand, String engineNumber, String model) {
        List<Item> items = stockByBrand.computeIfAbsent(brand, b -> new ArrayList<>());
        items.add(new Item(engineNumber, model));
        // Optional: keep items sorted by engineNumber or model
        // items.sort(Comparator.comparing(Item::getEngineNumber));
    }

    // Delete stock by brand + engine number
    public boolean deleteStock(String brand, String engineNumber) {
        List<Item> items = stockByBrand.get(brand);
        if (items == null) return false;
        boolean removed = items.removeIf(it -> it.getEngineNumber().equals(engineNumber));
        if (items.isEmpty()) stockByBrand.remove(brand);
        return removed;
    }

    // Search by brand + engine number
    public String searchStock(String brand, String engineNumber) {
        List<Item> items = stockByBrand.get(brand);
        if (items == null) return "Brand not found";
        return items.stream()
            .filter(it -> it.getEngineNumber().equals(engineNumber))
            .findFirst()
            .map(Item::getModel)
            .orElse("Stock not found");
    }

    // View all stocks sorted by brand
    public void printAll() {
        stockByBrand.forEach((brand, items) -> {
            System.out.println("Brand: " + brand);
            for (Item it : items) {
                System.out.println("  Engine: " + it.getEngineNumber() + " | Model: " + it.getModel());
            }
        });
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addStock("Honda", "142QVTSIUR", "CB500");
        inv.addStock("Yamaha", "P2CTS80XE", "R3");
        inv.addStock("Honda", "HX9001", "CBR600");

        System.out.println("Search Honda 142QVTSIUR: " + inv.searchStock("Honda", "142QVTSIUR"));
        inv.deleteStock("Honda", "142QVTSIUR");
        System.out.println("After deletion: " + inv.searchStock("Honda", "142QVTSIUR"));
        inv.printAll(); // already sorted by brand
    }
}