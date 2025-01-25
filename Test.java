import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Test producing fuel
        Map<String, Integer> fuelAmounts = new HashMap<>();
        fuelAmounts.put("RON95", 100);
        fuelAmounts.put("RON97", 200);
        fuelAmounts.put("RON100", 150);
        inventory.produceFuel(fuelAmounts);

        // Test selling fuel
        fuelAmounts.clear();
        fuelAmounts.put("RON95", 50);
        fuelAmounts.put("RON97", 100);
        fuelAmounts.put("RON100", 75);
        Customer customer = new Customer("BHRAMADEV", "SUBANG", "+60 13-303 1325", "Shell Oil Company");
        Transportation transportation = new Transportation("HARITH", "DKITTY1278", "+60 11-1325 4296", "KIT2346");
        inventory.sellFuel(fuelAmounts, customer, transportation);

        // Test getting fuel stocks
        inventory.getFuelStocks();
    }
}
