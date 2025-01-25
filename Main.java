import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Fuel Manufacturer =====");
            System.out.println("1. Produce fuel");
            System.out.println("2. Sell fuel");
            System.out.println("3. Check fuel stocks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter fuel types and amounts to produce (e.g., RON95:100 RON97:200): ");
                    String inputProduce = scanner.nextLine();
                    Map<String, Integer> produceAmounts = parseFuelAmounts(inputProduce);
                    inventory.produceFuel(produceAmounts);
                    break;
                case 2:
                    System.out.print("Enter fuel types and amounts to sell (e.g., RON95:100 RON97:200): ");
                    String inputSell = scanner.nextLine();
                    Map<String, Integer> sellAmounts = parseFuelAmounts(inputSell);
                    System.out.print("Enter receiver name: ");
                    String receiverName = scanner.nextLine();
                    System.out.print("Enter receiver address: ");
                    String receiverAddress = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter gas company name: ");
                    String gasCompanyName = scanner.nextLine();
                    System.out.print("Enter driver name: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Enter driver ID: ");
                    String driverID = scanner.nextLine();
                    System.out.print("Enter driver phone number: ");
                    String driverPhoneNumber = scanner.nextLine();
                    System.out.print("Enter truck number plate: ");
                    String truckNumberPlate = scanner.nextLine();

                    Customer customer = new Customer(receiverName, receiverAddress, gasCompanyName, phoneNumber);
                    Transportation transportation = new Transportation(driverName, driverID, driverPhoneNumber, truckNumberPlate);
                    inventory.sellFuel(sellAmounts, customer, transportation);
                    break;
                case 3:
                    inventory.getFuelStocks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Map<String, Integer> parseFuelAmounts(String input) {
        Map<String, Integer> fuelAmounts = new HashMap<>();
        String[] pairs = input.split(" ");
        for (String pair : pairs) {
            String[] parts = pair.split(":");
            if (parts.length == 2) {
                String fuelType = parts[0].toUpperCase();
                int amount = Integer.parseInt(parts[1]);
                fuelAmounts.put(fuelType, amount);
            }
        }
        return fuelAmounts;
    }
}
