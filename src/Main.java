import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        boolean flag2 = true;

        while (flag) {
            System.out.println("\t\t ____              _       _____           _");
            System.out.println("\t\t|  _ \\            | |     / ____|         | | ");
            System.out.println("\t\t| |_) | __ _ _ __ | | __ | (___  _   _ ___| |_ ___ _ __ ___");
            System.out.println("\t\t|  _ < / _` | '_ \\| |/ /  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\");
            System.out.println("\t\t| |_) | (_| | | | |   <   ____) | |_| \\__ \\ ||  __/ | | | | |");
            System.out.println("\t\t|____/ \\__,_|_| |_|_|\\_\\ |_____/ \\__, |___/\\__\\___|_| |_| |_|");
            System.out.println("\t\t                                   _/ |");
            System.out.println("\t\t                                  |__/");
            System.out.println("\t\t=============================================================");

            System.out.println("\n\n\n\t\t\t   [1] Deposit\t\t   [2] Loans\n\n\t\t\t   [3] Tax\t\t   [4] Share Market\n\n\t\t\t   [5] Exit");


            System.out.print("\n\n\n\tEnter an option to continue -> ");
            int op = input.nextInt();

            while (op == 1){

                System.out.println("\n\n\n\n\n\n\t\t\t      _____                       _ _");
                System.out.println("\t\t\t     |  __ \\                     (_) |");
                System.out.println("\t\t\t     | |  | | ___ _ __   ___  ___ _| |_");
                System.out.println("\t\t\t     | |  | |/ _ \\ '_ \\ / _ \\/ __| | __|");
                System.out.println("\t\t\t     | |__| |  __/ |_) | (_) \\__ \\ | |_");
                System.out.println("\t\t\t     |_____/ \\___| .__/ \\___/|___/_|\\__|");
                System.out.println("\t\t\t                 | |");
                System.out.println("\t\t\t                 |_|");
                System.out.println("\t\t\t     ===================================");

                System.out.println("\n\n\n\t\t\t\t     [1] Savings account\n\n\t\t\t\t     [2] Fixed deposit\n\n\t\t\t\t     [3] Back");

                System.out.print("\n\n\n\tEnter an option to continue -> ");
                int op1 = input.nextInt();



                if(op1 == 1) {
                    System.out.println("\n\n\n\n\n\n\t  _____              _                                                     _");
                    System.out.println("\t / ____|            (_)                     /\\                            | |");
                    System.out.println("\t| (___   __ ___    ___ _ __   __ _ ___     /  \\   ___ ___ ___  _   _ _ __ | |_");
                    System.out.println("\t \\___ \\ / _` \\ \\  / / | '_ \\ / _` / __|   / /\\ \\ / __/ __/ _ \\| | | | '_ \\| __|");
                    System.out.println("\t ____) | (_| |\\ \\/ /| | | | | (_| \\__ \\  / ____ \\ (_| (_| (_) | |_| | | | | |_");
                    System.out.println("\t|_____/ \\__,_| \\__/ |_|_| |_|\\__, |___/ /_/    \\_\\___\\___\\___/ \\__,_|_| |_|\\__|");
                    System.out.println("\t                              __/ |");
                    System.out.println("\t                             |___/");
                    System.out.println("\t===============================================================================");

                    System.out.print("\n\n\n\t\tEnter your amount : Rs.");
                    double amount = input.nextDouble();

                    double interestRate = 5, interestPerMonth = (amount * interestRate)/100, interestPerYear = interestPerMonth * 12;

                    String strInterestPerMonth = String.format("%.2f", interestPerMonth);
                    String strInterestPerYear = String.format("%.2f", interestPerYear);

                    System.out.println("\n\n\n\t\tThe interest you get per month : Rs." + strInterestPerMonth);

                    System.out.println("\n\t\tThe interest you get per year  : Rs." + strInterestPerYear);

                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                       flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }

                }
                if(op1 == 2) {
                    System.out.println("\n\n\n\n\n\n\t\t   ______ _              _       _                      _ _");
                    System.out.println("\t\t  |  ____(_)            | |     | |                    (_) |");
                    System.out.println("\t\t  | |__   ___  _____  __| |   __| | ___ _ __   ___  ___ _| |_");
                    System.out.println("\t\t  |  __| | \\ \\/ / _ \\/ _` |  / _` |/ _ \\ '_ \\ / _ \\/ __| | __|");
                    System.out.println("\t\t  | |    | |>  <  __/ (_| | | (_| |  __/ |_) | (_) \\__ \\ | |_");
                    System.out.println("\t\t  |_|    |_/_/\\_\\___|\\__,_|  \\__,_|\\___| .__/ \\___/|___/_|\\__|");
                    System.out.println("\t\t                                       | |");
                    System.out.println("\t\t                                       |_|");
                    System.out.println("\t\t  ============================================================");

                    System.out.print("\n\n\n\t\t\tYour amount\t     : Rs.");
                    double amount = input.nextDouble();

                    System.out.print("\n\t\t\tEnter number of year : ");
                    int years = input.nextInt();

                    double interestRate = 8, interestPerMonth = (amount * interestRate)/100, totalAtEnd = amount + (interestPerMonth * 12 * years);

                    String strInterestPerMonth = String.format("%.2f", interestPerMonth);
                    String strTotalAtEnd = String.format("%.2f", totalAtEnd);

                    System.out.println("\n\n\n\t\t\tInterest you get per Month : Rs." + strInterestPerMonth);

                    System.out.println("\n\t\t\tTotal amount at the end\t   : Rs." + strTotalAtEnd);

                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }

                }
                if(op1 == 3) {break;}
                if (op1 < 1 || op1 > 3){return;}
            }
            while(op == 2) {
                System.out.println("\n\n\n\n\n\n\t\t\t\t   _");
                System.out.println("\t\t\t\t  | |");
                System.out.println("\t\t\t\t  | |     ___   __ _ _ __");
                System.out.println("\t\t\t\t  | |    / _ \\ / _` | '_ \\");
                System.out.println("\t\t\t\t  | |___| (_) | (_| | | | |");
                System.out.println("\t\t\t\t  |______\\___/ \\__,_|_| |_|");
                System.out.println("\t\t\t\t  =========================");

                System.out.println("\n\n\n\t\t\t\t     [1] Personal Loan\n\n\t\t\t\t     [2] Business Loan\n\n\t\t\t\t     [3] Home equity Loan\n\n\t\t\t\t     [4] Car Finance");

                System.out.print("\n\n\n\tEnter an option to continue -> ");
                int op2 = input.nextInt();

                if (op2 == 1) {  }
                    if (op2 == 2) {   }
                        if (op2 == 3) {  }
                            if (op2 == 4) { }
                                if (op2 < 0 || op2 > 4) {
                                    System.exit(0);
                                }

                            }
            if (op == 3) {
                    System.out.println("\n\n\n\n\n\n\t\t\t\t    _______");
                    System.out.println("\t\t\t\t   |__   __|");
                    System.out.println("\t\t\t\t      | | __ ___  __");
                    System.out.println("\t\t\t\t      | |/ _` \\ \\/ /");
                    System.out.println("\t\t\t\t      | | (_| |>  <");
                    System.out.println("\t\t\t\t      |_|\\__,_/_/\\_\\");
                    System.out.println("\t\t\t\t   ==================");

                    System.out.println("\n\n\n\t\t\t\t      [1] Rent Tax\n\n\t\t\t\t      [2] Income Tax\n\n\t\t\t\t      [3] Payable Tax\n\n\t\t\t\t      [4] Leasing");

                    System.out.print("\n\n\n\tEnter an option to continue -> ");
                    int op3 = input.nextInt();
                }
            if (op == 4) {
                        System.out.println("\n\n\n\n\n\n\t\t  _____ _                      __  __            _        _ ");
                        System.out.println("\t\t / ____| |                    |  \\/  |          | |      | |");
                        System.out.println("\t\t| (___ | |__   __ _ _ __ ___  | \\  / | __ _ _ __| | _____| |_");
                        System.out.println("\t\t \\___ \\| '_ \\ / _` | '__/ _ \\ | |\\/| |/ _` | '__| |/ / _ \\ __|");
                        System.out.println("\t\t ____) | | | | (_| | | |  __/ | |  | | (_| | |  |   <  __/ |_");
                        System.out.println("\t\t|_____/|_| |_|\\__,_|_|  \\___| |_|  |_|\\__,_|_|  |_|\\_\\___|\\__|");
                        System.out.println("\t\t==============================================================");

                        System.out.print("\n\n\n\t\t\tEnter your amount : Rs.");
                        double amount = input.nextDouble();

                        double sharePrice, shares, shareDividend, annualDividend;

                        sharePrice = 80;
                        shareDividend = 6;

                        shares = amount / sharePrice;
                        String strShares = String.format("%.0f", shares);

                        annualDividend = shares * shareDividend * 12;
                        String strAnnualDividend = String.format("%.2f", annualDividend);

                        System.out.println("\n\n\n\t\t\tNumber of shares available : " + strShares);

                        System.out.println("\n\t\t\tAnnual dividend\t\t   : Rs." + strAnnualDividend);
                    }
            if (op == 5) { return; }
        }
    }
}
