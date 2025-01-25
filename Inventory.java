import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> fuelStocks;
    private Map<String, Double> fuelPrices;

    public Inventory() {
        fuelStocks = new HashMap<>();
        fuelStocks.put("RON95", 0);
        fuelStocks.put("RON97", 0);
        fuelStocks.put("RON100", 0);

        fuelPrices = new HashMap<>();
        fuelPrices.put("RON95", 2.0);
        fuelPrices.put("RON97", 2.5);
        fuelPrices.put("RON100", 3.0);
    }

    public void produceFuel(Map<String, Integer> fuelAmounts) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("===== Fuel Production Receipt =====\n");
        for (String fuelType : fuelAmounts.keySet()) {
            int amount = fuelAmounts.get(fuelType);
            if (fuelStocks.containsKey(fuelType)) {
                fuelStocks.put(fuelType, fuelStocks.get(fuelType) + amount);
                receipt.append("Produced ").append(amount).append(" liters of ").append(fuelType).append(" fuel.\n");
            } else {
                receipt.append("Invalid fuel type: ").append(fuelType).append("\n");
            }
        }
        System.out.println(receipt);
    }

    public void sellFuel(Map<String, Integer> fuelAmounts, Customer customer, Transportation transportation) {
        double totalAmount = 0;
        double totalPrice = 0;
        StringBuilder receipt = new StringBuilder();
        System.out.println(" ");
        receipt.append("===== Fuel Sale Receipt =====\n");
        for (String fuelType : fuelAmounts.keySet()) {
            int amount = fuelAmounts.get(fuelType);
            if (fuelStocks.containsKey(fuelType)) {
                int availableStock = fuelStocks.get(fuelType);
                if (amount <= availableStock) {
                    fuelStocks.put(fuelType, availableStock - amount);
                    double fuelPrice = fuelPrices.get(fuelType);
                    double fuelTotalPrice = fuelPrice * amount;

                    receipt.append("Sold ").append(amount).append(" liters of ").append(fuelType).append(" fuel.\n");
                    receipt.append("Fuel Price: RM").append(fuelPrice).append("\n");
                    receipt.append("Total Price: RM").append(fuelTotalPrice).append("\n");

                    totalAmount += amount;
                    totalPrice += fuelTotalPrice;
                } else {
                    receipt.append("Not enough ").append(fuelType).append(" fuel available for sale.\n");
                }
            } else {
                receipt.append("Invalid fuel type: ").append(fuelType).append("\n");
            }
        }

        if (totalAmount > 0) {
            receipt.append("\n===== Summary =====\n");
            receipt.append("Total Amount Sold: ").append(totalAmount).append(" liters\n");
            receipt.append("Total Price: RM").append(totalPrice).append("\n");
            receipt.append("Receiver Details:\n");
            receipt.append("Name: ").append(customer.getName()).append("\n");
            receipt.append("Address: ").append(customer.getAddress()).append("\n");
            receipt.append("Phone Number: ").append(customer.getPhoneNumber()).append("\n");
            receipt.append("Gas Company Name: ").append(customer.getGasCompanyName()).append("\n");
            receipt.append("\nDriver Details:\n");
            receipt.append("Driver Name: ").append(transportation.getDriverName()).append("\n");
            receipt.append("Driver ID: ").append(transportation.getDriverID()).append("\n");
            receipt.append("Driver Phone Number: ").append(transportation.getDriverPhoneNumber()).append("\n");
            receipt.append("Truck Number Plate: ").append(transportation.getTruckNumberPlate()).append("\n");
        }

        System.out.println(receipt);
    }

    public void getFuelStocks() {
        System.out.println("Current fuel stocks:");
        for (String fuelType : fuelStocks.keySet()) {
            int stock = fuelStocks.get(fuelType);
            System.out.println(fuelType + ": " + stock + " liters");
        }
    }
}
