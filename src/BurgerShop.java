import java.util.Scanner;

public class BurgerShop{
    private static final int MAX_ORDERS = 100;
    private static final String[] orderIds = new String[MAX_ORDERS];
    private static final String[] customerIds = new String[MAX_ORDERS];
    private static final String[] customerNames = new String[MAX_ORDERS];
    private static final int[] burgerQuantities = new int[MAX_ORDERS];
    private static final int[] orderStatuses = new int[MAX_ORDERS];
    private static int orderCount = 0;
    private static final double BURGER_PRICE = 500;
    private static final Scanner scanner = new Scanner(System.in);

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            displayHomePage();
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                       PLACE ORDER                        |");
                    System.out.println("============================================================");
                    placeOrder();
                    break;
                case 2:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                       BEST Customer                      |");
                    System.out.println("============================================================");
                    searchBestCustomer();
                    break;
                case 3:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                   SEARCH ORDER DETAILS                   |");
                    System.out.println("============================================================");
                    searchOrder();
                    break;
                case 4:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                SEARCH CUSTOMER DETAILS                   |");
                    System.out.println("============================================================");
                    searchCustomer();
                    break;
                case 5:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                      VIEW ORDER LIST                     |");
                    System.out.println("============================================================");
                    viewOrders();
                    break;
                case 6:
                    clearConsole();
                    System.out.println("\n============================================================");
                    System.out.println("|                   UPDATE ORDER DETAILS                   |");
                    System.out.println("============================================================");
                    updateOrderDetails();
                    break;
                case 7:
                    clearConsole();
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);
    }

    private static void displayHomePage() {
        clearConsole();
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
        System.out.println("================");

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

            System.out.print("\nAre you confirming the order? (Y/N): ");
            char confirmation = scanner.next().charAt(0);
            if (confirmation == 'Y' || confirmation == 'y') {
                orderCount++;
                System.out.println("\nOrder placed successfully!");
            } else {
                System.out.println("\nOrder not confirmed.");
            }

            System.out.print("\nDo you want to place another order? (Y/N): ");
            char placeAnotherOrder = scanner.next().charAt(0);
            if (placeAnotherOrder == 'N' || placeAnotherOrder == 'n') {
                return;
            } else if (placeAnotherOrder == 'Y' || placeAnotherOrder == 'y') {
                placeOrder();
            }
        } else {
            System.out.println("\nMaximum orders reached. Cannot place more orders.");
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
            System.out.println("\nNo orders placed yet. Cannot determine the best customer.");
            return;
        }

        double[] totalPurchasesArray = new double[orderCount];
        for (int i = 0; i < orderCount; i++) {
            totalPurchasesArray[i] = calculateTotalPurchases(customerIds[i]);
        }

        for (int i = 0; i < orderCount - 1; i++) {
            for (int j = i + 1; j < orderCount; j++) {
                if (totalPurchasesArray[j] > totalPurchasesArray[i]) {
                    double tempTotalPurchases = totalPurchasesArray[i];
                    totalPurchasesArray[i] = totalPurchasesArray[j];
                    totalPurchasesArray[j] = tempTotalPurchases;

                    String tempCustomerId = customerIds[i];
                    customerIds[i] = customerIds[j];
                    customerIds[j] = tempCustomerId;

                    String tempCustomerName = customerNames[i];
                    customerNames[i] = customerNames[j];
                    customerNames[j] = tempCustomerName;
                }
            }
        }
        System.out.println("\n");
        String horizontalLine = "+-----------------+-----------------+-----------------+";
        System.out.println(horizontalLine);
        System.out.printf("| %-15s | %-15s | %-15s |\n", "CustomerID", "Name", "Total Purchases");
        System.out.println(horizontalLine);

        for (int i = 0; i < orderCount; i++) {
            System.out.printf("| %-15s | %-15s | Rs. %-11.2f |\n",
                    customerIds[i], customerNames[i], totalPurchasesArray[i]);
        }

        System.out.println(horizontalLine);

        System.out.print("\nDo you want to go back to the main menu? (Y/N): ");
        char goBack = scanner.next().charAt(0);
        if (goBack == 'N' || goBack == 'n') {
            exit();
        } else if (goBack == 'Y' || goBack == 'y') {
            return;
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
        System.out.print("\nEnter Order ID: ");
        String orderId = scanner.nextLine();

        int foundOrderIndex = findOrderIndex(orderId);
        if (foundOrderIndex != -1) {
            displayOrderDetails(foundOrderIndex);
        } else {
            System.out.print("\nInvalid Order ID. Do you want to enter again? (Y/N)> ");
            char invalidOrderId = scanner.next().charAt(0);
            scanner.nextLine();

            if (invalidOrderId == 'N' || invalidOrderId == 'n') {
                return;
            } else if (invalidOrderId == 'Y' || invalidOrderId == 'y') {
                searchOrder();
            }
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
        System.out.print("\nEnter Customer ID: ");
        String customerId = scanner.nextLine();

        int foundCustomerIndex = findCustomerIndex(customerId);
        if (foundCustomerIndex != -1) {
            displayCustomerDetails(foundCustomerIndex);
        } else {
            System.out.print("\nThis customer ID is not added yet....");
            System.out.print("\n");
            System.out.print("\nDo you want to search another customer detail (Y/N): ");
            char notYet = scanner.next().charAt(0);

            scanner.nextLine();

            if (notYet == 'N' || notYet == 'n') {
                return;
            } else if (notYet == 'Y' || notYet == 'y') {
                searchCustomer();
            }
        }
    }

    private static void viewOrders() {
        System.out.println("\n[1] Delivered Orders");
        System.out.println("[2] Preparing Orders");
        System.out.println("[3] Canceled Orders");

        System.out.print("\nEnter an option to continue > ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                clearConsole();
                System.out.println("\n============================================================");
                System.out.println("|                        DELIVERED ORDER                   |");
                System.out.println("============================================================");
                deliveredOrders(1);
                break;
            case 2:
                clearConsole();
                System.out.println("\n============================================================");
                System.out.println("|                      PREPARING ORDER                     |");
                System.out.println("============================================================");
                preparingOrders(0);
                break;
            case 3:
                clearConsole();
                System.out.println("\n============================================================");
                System.out.println("|                       CANCELED ORDER                     |");
                System.out.println("============================================================");
                canceledOrders(2);
                break;
            default:
                System.out.println("\nInvalid choice. Please enter a valid option.");
        }
    }

    private static void deliveredOrders(int status) {
        displayOrdersByStatus("DELIVERED", status);
    }

    private static void preparingOrders(int status) {
        displayOrdersByStatus("PREPARING", status);
    }

    private static void canceledOrders(int status) {
        displayOrdersByStatus("CANCELED", status);
    }

    private static void displayOrdersByStatus(String orderStatus, int status) {
        System.out.println("\n");
        String horizontalLine = "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+";
        System.out.println(horizontalLine);

        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "OrderID", "CustomerID", "Name", "Quantity", "OrderValue", "OrderStatus");

        System.out.println(horizontalLine);

        for (int i = 0; i < orderCount; i++) {
            if (orderStatuses[i] == status) {
                System.out.printf("| %-15s | %-15s | %-15s | %-15d | Rs. %-11.2f | %-15s |\n",
                        orderIds[i], customerIds[i], customerNames[i],
                        burgerQuantities[i], burgerQuantities[i] * BURGER_PRICE,
                        orderStatus);
            }
        }

        System.out.println(horizontalLine);
        System.out.print("\nDo you want to go to the home page (Y/N): ");
        char goHome = scanner.next().charAt(0);
        if (goHome == 'N' || goHome == 'n') {
            viewOrders();
        } else if (goHome == 'Y' || goHome == 'y') {
            return;
        }
    }


    private static void updateOrderDetails() {
        System.out.print("\nEnter Order ID - ");
        String orderId = scanner.nextLine();

        int foundOrderIndex = findOrderIndex(orderId);
        if (foundOrderIndex != -1) {
            displayOrderDetails(foundOrderIndex);

            if (orderStatuses[foundOrderIndex] == 2) {
                System.out.println("\nThis order has already been canceled. You cannot update a canceled order.");
            } else if (orderStatuses[foundOrderIndex] == 0) {
                System.out.print("\nWhat do you want to update?\n");
                System.out.println("[1] Quantity");
                System.out.println("[2] Status");

                System.out.print("\nEnter your option - ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        updateOrderQuantity(foundOrderIndex);
                        break;
                    case 2:
                        updateOrderStatus(foundOrderIndex);
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid option.");
                }
            } else if (orderStatuses[foundOrderIndex] == 1) {
                System.out.println("\nThis order has already been delivered. You cannot update a delivered order.");
            }

            System.out.print("\nDo you want to update another order detail? (Y/N): ");
            char op = scanner.next().charAt(0);
            scanner.nextLine();
            if (op == 'N' || op == 'n') {
                return;
            } else if (op == 'Y' || op == 'y') {
                updateOrderDetails();
            }
        } else {
            System.out.println("\nInvalid Order ID. Unable to update order.");
        }
    }



    private static void updateOrderQuantity(int orderIndex) {
        System.out.println("Quantity Update");
        System.out.println("==============");

        System.out.println("\nOrder ID: " + orderIds[orderIndex]);
        System.out.println("Customer ID: " + customerIds[orderIndex]);
        System.out.println("Customer Name: " + customerNames[orderIndex]);

        System.out.print("\nEnter your quantity update value - ");
        int newQuantity;
        do {
            newQuantity = scanner.nextInt();
            scanner.nextLine();
        } while (newQuantity <= 0);

        burgerQuantities[orderIndex] = newQuantity;
        System.out.println("\nOrder Quantity updated successfully!");

        System.out.println("\nNew Order Quantity - " + burgerQuantities[orderIndex]);

        double updatedOrderValue = burgerQuantities[orderIndex] * BURGER_PRICE;
        System.out.println("New Order Value - Rs. " + updatedOrderValue);

        System.out.print("\nDo you want to update another order detail? (Y/N): ");
        char op = scanner.next().charAt(0);
        scanner.nextLine();
        if (op == 'N' || op == 'n') {
            return;
        } else if (op == 'Y' || op == 'y') {
            updateOrderDetails();
        }
    }


    private static void updateOrderStatus(int orderIndex) {
        System.out.println("Order Status Update");
        System.out.println("===================");

        System.out.println("\nOrder ID: " + orderIds[orderIndex]);
        System.out.println("Customer ID: " + customerIds[orderIndex]);
        System.out.println("Customer Name: " + customerNames[orderIndex]);

        System.out.println("\n[1] PREPARING");
        System.out.println("[2] DELIVERED");
        System.out.println("[3] CANCEL");

        System.out.print("\nEnter new Order Status (1-3): ");
        int newStatus;
        do {
            newStatus = scanner.nextInt();
            scanner.nextLine();  //
        } while (newStatus < 1 || newStatus > 3);

        orderStatuses[orderIndex] = newStatus - 1;
        System.out.println("\nOrder Status updated successfully!");

        System.out.println("\nNew Order Status: " + getOrderStatusString(orderStatuses[orderIndex]));

        System.out.print("\nDo you want to update another order detail? (Y/N): ");
        char updateAnother = scanner.next().charAt(0);
        scanner.nextLine();  //
        if (updateAnother == 'N' || updateAnother == 'n') {
            return;
        } else if (updateAnother == 'Y' || updateAnother == 'y') {
            updateOrderDetails();
        }
    }



    private static void displayOrderDetails(int orderIndex) {
        System.out.println("\n");
        String horizontalLine = "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+";
        System.out.println(horizontalLine);

        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "OrderID", "CustomerID", "Name", "Quantity", "OrderValue", "OrderStatus");

        System.out.println(horizontalLine);

        System.out.printf("| %-15s | %-15s | %-15s | %-15d | Rs. %-11.2f | %-15s |\n",
                orderIds[orderIndex], customerIds[orderIndex], customerNames[orderIndex],
                burgerQuantities[orderIndex], burgerQuantities[orderIndex] * BURGER_PRICE,
                getOrderStatusString(orderStatuses[orderIndex]));

        System.out.println(horizontalLine);
        System.out.println("\n");
    }

    private static void displayCustomerDetails(int customerIndex) {
        System.out.println("\nCustomer ID: " + customerIds[customerIndex]);
        System.out.println("Customer Name: " + customerNames[customerIndex]);

        System.out.println("\nCustomer Order Details");
        System.out.println("======================");
        System.out.println("\n");
        System.out.println("+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s |\n", "Order ID", "Quantity", "Total Value");
        System.out.println("+-----------------+-----------------+-----------------+");

        for (int i = 0; i < orderCount; i++) {
            if (customerIds[i].equals(customerIds[customerIndex])) {
                System.out.printf("| %-15s | %-15d | Rs. %-11.2f |\n",
                        orderIds[i], burgerQuantities[i], burgerQuantities[i] * BURGER_PRICE);
            }
        }

        System.out.println("+-----------------+-----------------+-----------------+");
        System.out.print("\nDo you want to search another customer detail (Y/N): ");
        char notYet = scanner.next().charAt(0);

        scanner.nextLine();

        if (notYet == 'N' || notYet == 'n') {
            return;
        } else if (notYet == 'Y' || notYet == 'y') {
            searchCustomer();
        }
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
