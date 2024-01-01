
import com.sun.source.tree.WhileLoopTree;

import java.util.*;
    class Test {
        private static int [][] Orders = new int[0][4];
        private static int LastOrder = 1;
        private static Scanner input = new Scanner(System.in);

        public static int[][] incrementArray(){
            int[][] temp = new int[Orders.length + 1][4];
            for(int i = 0; i < Orders.length; i++){
                for(int j = 0; j < Orders[i].length; j++){
                    temp[i][j] = Orders[i][j];
                }
            }
            return temp;
        }
        public static void main(String[] args) {

            HomePage();

        }

        private static void HomePage() {

            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "iHungry Burger");
            System.out.printf("-------------------------------------%n");

            System.out.println("[1]Place Order\t\t [2]Search Best Customer\n [3]Search Order\t\t [4]Search Customer\n [5]View Orders\t\t [6]Update Order Details\n [7]Exit\n\n Enter an option to continue >");
            int op = input.nextInt();


            switch (op ){
                case 1 : PlaceOrder(); break;
                case 2 : SearchBestCust();break;
                case 3 : SearchOrder();break;
                case 4 : SearchCust();break;
                case 5 : ViewOrders();break;
                case 6 : UpdateOrderDetails();break;
                case 7 : return;

            }
        }

        private static void PlaceOrder() {
            clearConsole();
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "Place Order");
            System.out.printf("-------------------------------------%n");

            Orders = incrementArray();


            for (int i = 0; i < Orders.length; i++) {
                Orders[i][0] = LastOrder;
                System.out.println("\nOrder ID - B" + String.format("%04d", Orders[i][0]) + "\n===============");
                LastOrder = LastOrder++;

            }


                    System.out.println("Enter Customer ID(Phone.No) : ");
                    String num = input.next();

                    char charNum = num.charAt(0);

                    int count = 0;
                    String s = String.valueOf(num);
                    for (int i = 0; i < s.length(); i++) {
                        char ch = s.charAt(i);
                        if (ch == '1')
                            count++;
                    }


            boolean flag = true;
            while(flag){
                if (charNum == 0 && count == 10) {
                    for (int i = 0; i < Orders.length; i++) {
                        for (int j = 0; j < Orders[i][j]; j++) {

                        }
                    }
                    flag = false;
                } else {

                    System.out.println("You entered invalid phone number.Enter valid phone number :");

                }

            }
        }




        private static void SearchBestCust() {
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "Search Best Customer");
            System.out.printf("-------------------------------------%n");

        }

        private static void SearchOrder() {
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "Search Order");
            System.out.printf("-------------------------------------%n");

        }

        private static void SearchCust() {
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "Search Customer");
            System.out.printf("-------------------------------------%n");

        }

        private static void ViewOrders() {
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "View Orders");
            System.out.printf("-------------------------------------%n");

        }

        private static void UpdateOrderDetails() {
            System.out.printf("-------------------------------------%n");
            System.out.printf("|           %s           |%n", "Update Order Details");
            System.out.printf("-------------------------------------%n");

        }
        public static void exit(){
            clearConsole();
            System.out.println("\n\t\tYou left the program...\n");
            System.exit(0);
        }

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
                // Handle any exceptions.
            }


        }


    }


