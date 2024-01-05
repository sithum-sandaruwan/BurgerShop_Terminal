import java.util.Scanner;

public class BurgerShop {
    private static final int MAX_ORDERS = 100;
    private static final String[] orderIds = new String[MAX_ORDERS];
    private static final String[] customerIds = new String[MAX_ORDERS];
    private static final String[] customerNames = new String[MAX_ORDERS];
    private static final int[] burgerQuantities = new int[MAX_ORDERS];
    private static final int[] orderStatuses = new int[MAX_ORDERS];
    private static int orderCount = 0;
    private static final double BURGER_PRICE = 500;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayHomePage();
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------\n\t\tPlace Order\t\t\n----------------------------");
                    placeOrder();
                    break;
                case 2:
                    searchBestCustomer();
                    break;
                case 3:
                    searchOrder();
                    break;
                case 4:
                    searchCustomer();
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    updateOrderDetails();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);
    }

    private static void displayHomePage() {
        System.out.println("============================================================");
        System.out.println("|                     iHungry Burger                       |");
        System.out.println("============================================================");
        System.out.print("\n[1] Place Order");
        System.out.println("\t\t\t\t\t\t[2] Search Best Customer");
        System.out.print("[3] Search Order");
        System.out.println("\t\t\t\t\t[4] Search Customer");
        System.out.print("[5] View Orders");
        System.out.println("\t\t\t\t\t\t[6] Update Order Details");
        System.out.println("[7] Exit");
    }

    private static void placeOrder() {

        System.out.println("\nORDER ID - "+generateOrderId());
        System.out.println("=============");

        if (orderCount < MAX_ORDERS) {
            String orderId = generateOrderId();
            orderIds[orderCount] = orderId;

            System.out.println("");

            String customerId;
            do {
                System.out.print("Enter Customer ID (Phone no.): ");
                customerId = scanner.nextLine();
            } while (!isValidPhoneNumber(customerId));
            customerIds[orderCount] = customerId;

            int existingCustomerIndex = findCustomerIndex(customerId);
            if (existingCustomerIndex != -1) {
                System.out.println("Customer Name: " + customerNames[existingCustomerIndex]);
            } else {
                System.out.print("Enter Customer Name: ");
                customerNames[orderCount] = scanner.nextLine();
            }

            System.out.print("Enter Burger Quantity: ");
            int burgerQuantity;
            do {
                burgerQuantity = scanner.nextInt();
            } while (burgerQuantity <= 0);
            burgerQuantities[orderCount] = burgerQuantity;

            orderStatuses[orderCount] = 0; // Set initial order status to PREPARING

            double totalBill = burgerQuantity * BURGER_PRICE;
            System.out.println("Total Bill Value: Rs. " + totalBill);

            System.out.print("Are you confirming the order? (Y/N): ");
            char confirmation = scanner.next().charAt(0);
            if (confirmation == 'Y' || confirmation == 'y') {
                orderCount++;
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Order not confirmed.");
            }

            System.out.print("Do you want to place another order? (Y/N): ");
            char placeAnotherOrder = scanner.next().charAt(0);
            if (placeAnotherOrder == 'N' || placeAnotherOrder == 'n') {
                return;
            } else if (placeAnotherOrder == 'Y' || placeAnotherOrder == 'y') {
                placeOrder();
            }
        } else {
            System.out.println("Maximum orders reached. Cannot place more orders.");
        }
    }

    private static String generateOrderId() {
        return "B" + String.format("%04d",orderCount + 1);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.startsWith("0");
    }

    private static int findCustomerIndex(String customerId) {
        for (int i = 0; i < orderCount; i++) {
            if (customerIds[i].equals(customerId)) {
                return i;
            }
        }
        return -1;
    }

    private static void searchBestCustomer() {
        if (orderCount == 0) {
            System.out.println("No orders placed yet. Cannot determine the best customer.");
            return;
        }

        String bestCustomer = null;
        double maxTotalPurchases = -1;

        for (int i = 0; i < orderCount; i++) {
            String currentCustomerId = customerIds[i];
            double currentTotalPurchases = calculateTotalPurchases(currentCustomerId);

            if (currentTotalPurchases > maxTotalPurchases) {
                maxTotalPurchases = currentTotalPurchases;
                bestCustomer = customerNames[i];
            }
        }

        if (bestCustomer != null) {
            System.out.println("Best Customer: " + bestCustomer);
            System.out.println("Total Purchases: Rs. " + maxTotalPurchases);
        } else {
            System.out.println("No best customer found.");
        }
    }

    private static double calculateTotalPurchases(String customerId) {
        double totalPurchases = 0;

        for (int i = 0; i < orderCount; i++) {
            if (customerIds[i].equals(customerId)) {
                totalPurchases += burgerQuantities[i] * BURGER_PRICE;
            }
        }

        return totalPurchases;
    }
    private static void searchOrder() {
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();

        int foundOrderIndex = findOrderIndex(orderId);
        if (foundOrderIndex != -1) {
            displayOrderDetails(foundOrderIndex);
        } else {
            System.out.println("Invalid Order ID. Order not found.");
        }
    }

    private static int findOrderIndex(String orderId) {
        for (int i = 0; i < orderCount; i++) {
            if (orderIds[i].equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

    private static void searchCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        int foundCustomerIndex = findCustomerIndex(customerId);
        if (foundCustomerIndex != -1) {
            displayCustomerDetails(foundCustomerIndex);
        } else {
            System.out.println("Invalid Customer ID. Customer not found.");
        }
    }

    private static void viewOrders() {
        System.out.println("===============");
        System.out.println("  VIEW ORDERS");
        System.out.println("===============");
        System.out.println("1. Delivered Orders");
        System.out.println("2. Preparing Orders");
        System.out.println("3. Canceled Orders");
        System.out.println("4. Back to Main Menu");
        System.out.println("===============");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displayOrdersByStatus(1); // Delivered Orders
                break;
            case 2:
                displayOrdersByStatus(0); // Preparing Orders
                break;
            case 3:
                displayOrdersByStatus(2); // Canceled Orders
                break;
            case 4:
                // Back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void displayOrdersByStatus(int orderStatus) {
        System.out.println("===============");
        System.out.println("  ORDER LIST");
        System.out.println("===============");
        for (int i = 0; i < orderCount; i++) {
            if (orderStatuses[i] == orderStatus) {
                displayOrderDetails(i);
            }
        }
        System.out.println("===============");
    }

    private static void updateOrderDetails() {
        System.out.print("Enter Order ID to update: ");
        String orderId = scanner.nextLine();

        int foundOrderIndex = findOrderIndex(orderId);
        if (foundOrderIndex != -1 && orderStatuses[foundOrderIndex] == 0) {
            displayOrderDetails(foundOrderIndex);

            System.out.println("===============");
            System.out.println("  UPDATE OPTIONS");
            System.out.println("===============");
            System.out.println("1. Update Order Quantity");
            System.out.println("2. Update Order Status");
            System.out.println("3. Back to Main Menu");
            System.out.println("===============");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updateOrderQuantity(foundOrderIndex);
                    break;
                case 2:
                    updateOrderStatus(foundOrderIndex);
                    break;
                case 3:
                    // Back to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } else {
            System.out.println("Invalid Order ID or order status. Unable to update order.");
        }
    }

    private static void updateOrderQuantity(int orderIndex) {
        System.out.print("Enter new Burger Quantity: ");
        int newQuantity;
        do {
            newQuantity = scanner.nextInt();
        } while (newQuantity <= 0);

        burgerQuantities[orderIndex] = newQuantity;
        System.out.println("Order Quantity updated successfully!");
    }

    private static void updateOrderStatus(int orderIndex) {
        System.out.println("===============");
        System.out.println("  ORDER STATUS");
        System.out.println("===============");
        System.out.println("1. PREPARING");
        System.out.println("2. DELIVERED");
        System.out.println("3. CANCEL");
        System.out.println("===============");

        System.out.print("Enter new Order Status (1-3): ");
        int newStatus;
        do {
            newStatus = scanner.nextInt();
        } while (newStatus < 1 || newStatus > 3);

        orderStatuses[orderIndex] = newStatus - 1;
        System.out.println("Order Status updated successfully!");
    }

    private static void displayOrderDetails(int orderIndex) {
        System.out.println("===============");
        System.out.println("  ORDER DETAILS");
        System.out.println("===============");
        System.out.println("Order ID: " + orderIds[orderIndex]);
        System.out.println("Customer ID: " + customerIds[orderIndex]);
        System.out.println("Customer Name: " + customerNames[orderIndex]);
        System.out.println("Burger Quantity: " + burgerQuantities[orderIndex]);
        System.out.println("Order Status: " + getOrderStatusString(orderStatuses[orderIndex]));
        System.out.println("Total Bill Value: Rs. " + (burgerQuantities[orderIndex] * BURGER_PRICE));
        System.out.println("===============");
    }

    private static void displayCustomerDetails(int customerIndex) {
        System.out.println("===============");
        System.out.println("  CUSTOMER DETAILS");
        System.out.println("===============");
        System.out.println("Customer Name: " + customerNames[customerIndex]);
        System.out.println("===============");
    }

    private static String getOrderStatusString(int orderStatus) {
        switch (orderStatus) {
            case 0:
                return "PREPARING";
            case 1:
                return "DELIVERED";
            case 2:
                return "CANCEL";
            default:
                return "UNKNOWN";
        }
    }

    private static void exit() {
        System.out.println("\nYou left the program...\n");
        System.exit(0);
    }
}
