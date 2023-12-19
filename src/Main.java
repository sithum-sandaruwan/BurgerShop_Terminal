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

                System.out.println("\n\n\n\t\t\t\t     [1] Personal Loan\n\n\t\t\t\t     [2] Business Loan\n\n\t\t\t\t     [3] Home equity Loan\n\n\t\t\t\t     [4] Car Finance\n\n\t\t\t\t     [5]Back");

                System.out.print("\n\n\n\tEnter an option to continue -> ");
                int op2 = input.nextInt();

                if (op2 == 1) {
                    System.out.println("\n\n\n\n\n\n\t\t _____                                _   _");
                    System.out.println("\t\t|  __ \\                              | | | |");
                    System.out.println("\t\t| |__) |__ _ __ ___  ___  _ __   __ _| | | |     ___   __ _ _ __");
                    System.out.println("\t\t|  ___/ _ \\ '__/ __|/ _ \\| '_ \\ / _` | | | |    / _ \\ / _` | '_ \\");
                    System.out.println("\t\t| |  |  __/ |  \\__ \\ (_) | | | | (_| | | | |___| (_) | (_| | | | |");
                    System.out.println("\t\t|_|   \\___|_|  |___/\\___/|_| |_|\\__,_|_| |______\\___/ \\__,_|_| |_|");
                    System.out.println("\t\t==================================================================");

                    System.out.print("\n\n\n\t\t\tEnter your salary : Rs.");
                    double salary = input.nextDouble();

                    double maxAmount = salary * 5;
                    String strMaxAmount = String.format("%.2f", maxAmount);

                    if(salary >= 50000) {
                        System.out.println("\n\n\n\t\t\t\tThe maximum amount you can withdraw is Rs." + strMaxAmount);

                        System.out.print("\n\n\n\t\t\tEnter your amount      : Rs.");
                        double amount = input.nextDouble();

                        System.out.print("\n\t\t\tEnter number of months : ");
                        int months = input.nextInt();

                        double loanRate, installment;

                        if(amount > 200000 && months > 24) {
                            loanRate = 15;

                            installment = (amount + (amount * loanRate/100))/months;
                            String strInstallment = String.format("%.2f", installment);

                            System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." +strInstallment);
                        } else if(amount < 200000 && months < 24) {
                            loanRate = 10;

                            installment = (amount + (amount * loanRate/100))/months;
                            String strInstallment = String.format("%.2f", installment);

                            System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                        } else {
                            System.out.println("\n\n\n\t\t\t\tCannot grant you any monthly installment option!");
                        }
                    } else {
                        System.out.println("\n\n\n\t\t\t\tYou cannot get a loan...");
                    }
                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }


                }
                    if (op2 == 2) {
                        System.out.println("\n\n\n\n\n\n\t\t ____            _                       _");
                        System.out.println("\t\t|  _ \\          (_)                     | |");
                        System.out.println("\t\t| |_) |_   _ ___ _ _ __   ___  ___ ___  | |     ___   __ _ _ __");
                        System.out.println("\t\t|  _ <| | | / __| | '_ \\ / _ \\/ __/ __| | |    / _ \\ / _` | '_ \\");
                        System.out.println("\t\t| |_) | |_| \\__ \\ | | | |  __/\\__ \\__ \\ | |___| (_) | (_| | | | |");
                        System.out.println("\t\t|____/ \\__,_|___/_|_| |_|\\___||___/___/ |______\\___/ \\__,_|_| |_|");
                        System.out.println("\t\t=================================================================");

                        System.out.print("\n\n\n\t\t\tEnter your Income : Rs.");
                        double income = input.nextDouble();

                        double maxAmount = income * 5;
                        String strMaxAmount = String.format("%.2f", maxAmount);

                        if(income >= 50000) {
                            System.out.println("\n\n\n\t\t\t\tThe maximum amount you can withdraw is Rs." + strMaxAmount);

                            System.out.print("\n\n\n\t\t\tEnter your Amount      : Rs.");
                            double amount = input.nextDouble();

                            System.out.print("\n\t\t\tEnter number of months : ");
                            int months = input.nextInt();

                            double loanRate, installment;

                            if(amount > 500000 && months > 36) {
                                loanRate = 20;

                                installment = (amount + (amount * loanRate/100))/months;
                                String strInstallment = String.format("%.2f", installment);

                                System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                            } else if(amount < 500000 && months < 36) {
                                loanRate = 15;

                                installment = (amount + (amount * loanRate/100))/months;
                                String strInstallment = String.format("%.2f", installment);

                                System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                            } else {
                                System.out.println("\n\n\n\t\t\t\tCannot grant you any monthly installment option!");
                            }
                        } else {
                            System.out.println("\n\n\n\t\t\t\tYou cannot get a loan...");
                        }
                        System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                        char sel1 = input.next().charAt(0);

                        if (sel1 == 'y'){
                            flag = true;
                        } else if (sel1 == 'n') {
                            return;
                        }
                    }
                        if (op2 == 3) {
                            System.out.println("\n\n\n\n\n\n\t _    _                                         _ _           _");
                            System.out.println("\t| |  | |                                       (_) |         | | ");
                            System.out.println("\t| |__| | ___  _ __ ___   ___    ___  __ _ _   _ _| |_ _   _  | |     ___   __ _ _ __");
                            System.out.println("\t|  __  |/ _ \\| '_ ` _ \\ / _ \\  / _ \\/ _` | | | | | __| | | | | |    / _ \\ / _` | '_ \\");
                            System.out.println("\t| |  | | (_) | | | | | |  __/ |  __/ (_| | |_| | | |_| |_| | | |___| (_) | (_| | | | |");
                            System.out.println("\t|_|  |_|\\___/|_| |_| |_|\\___|  \\___|\\__, |\\__,_|_|\\__|\\__, | |______\\___/ \\__,_|_| |_|");
                            System.out.println("\t                                       | |             __/ |");
                            System.out.println("\t                                       |_|            |___/");
                            System.out.println("\t======================================================================================");

                            System.out.print("\n\n\n\t\t\tEnter your Salary : Rs.");
                            double salary = input.nextDouble();

                            double maxAmount = salary * 5;
                            String strMaxAmount = String.format("%.2f", maxAmount);

                            if(salary >= 50000) {
                                System.out.println("\n\n\n\t\t\t\tThe maximum amount you can withdraw is Rs." + strMaxAmount);

                                System.out.print("\n\n\n\t\t\tEnter your Amount      : Rs.");
                                double amount = input.nextDouble();

                                System.out.print("\n\t\t\tEnter number of months : ");
                                int months = input.nextInt();

                                double loanRate, installment;

                                if(amount > 500000 && months > 48) {
                                    loanRate = 8;

                                    installment = (amount + (amount * loanRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else if(amount < 500000 && months < 48) {
                                    loanRate = 6;

                                    installment = (amount + (amount * loanRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else {
                                    System.out.println("\n\n\n\t\t\t\tCannot grant you any monthly installment option!");
                                }
                            } else {
                                System.out.println("\n\n\n\t\t\t\tYou cannot get a loan...");
                            }

                            System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                            char sel1 = input.next().charAt(0);

                            if (sel1 == 'y'){
                                flag = true;
                            } else if (sel1 == 'n') {
                                return;
                            }

                        }
                            if (op2 == 4) {
                                System.out.println("\n\n\n\n\n\n\t\t ______ _                              _");
                                System.out.println("\t\t|  ____(_)                            | |");
                                System.out.println("\t\t| |__   _ _ __   __ _ _ __   ___ ___  | |     ___   __ _ _ __");
                                System.out.println("\t\t|  __| | | '_ \\ / _` | '_ \\ / __/ _ \\ | |    / _ \\ / _` | '_ \\");
                                System.out.println("\t\t| |    | | | | | (_| | | | | (_|  __/ | |___| (_) | (_| | | | |");
                                System.out.println("\t\t|_|    |_|_| |_|\\__,_|_| |_|\\___\\___| |______\\___/ \\__,_|_| |_|");
                                System.out.println("\t\t===============================================================");

                                System.out.print("\n\n\n\t\t\tEnter Value of the vehicle : Rs.");
                                double value = input.nextDouble();

                                System.out.print("\n\t\t\tEnter number of months     : ");
                                int months = input.nextInt();

                                double financeRate, installment;

                                if(months < 12) {
                                    financeRate = 6;

                                    installment = (value + (value * financeRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else if(months > 12 && months < 24) {
                                    financeRate = 10;

                                    installment = (value + (value * financeRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else if(months > 24 && months < 36) {
                                    financeRate = 14;

                                    installment = (value + (value * financeRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else if(months > 36) {
                                    financeRate = 16;

                                    installment = (value + (value * financeRate/100))/months;
                                    String strInstallment = String.format("%.2f", installment);

                                    System.out.println("\n\n\n\t\t\tYour Monthly installment : Rs." + strInstallment);
                                } else {
                                    System.out.println("\n\n\n\t\t\t\tCannot grant you any monthly installment option!");
                                }
                                System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                                char sel1 = input.next().charAt(0);

                                if (sel1 == 'y'){
                                    flag = true;
                                } else if (sel1 == 'n') {
                                    return;
                                }
                            }
                                if (op2 == 5) {
                                    break;
                                }
                                else if (op2 < 1 || op2 > 5) {
                                    return;
                                }

            }
            while (op == 3) {
                    System.out.println("\n\n\n\n\n\n\t\t\t\t    _______");
                    System.out.println("\t\t\t\t   |__   __|");
                    System.out.println("\t\t\t\t      | | __ ___  __");
                    System.out.println("\t\t\t\t      | |/ _` \\ \\/ /");
                    System.out.println("\t\t\t\t      | | (_| |>  <");
                    System.out.println("\t\t\t\t      |_|\\__,_/_/\\_\\");
                    System.out.println("\t\t\t\t   ==================");

                    System.out.println("\n\n\n\t\t\t\t      [1] Rent Tax\n\n\t\t\t\t      [2] Income Tax\n\n\t\t\t\t      [3] Payable Tax\n\n\t\t\t\t      [4] Leasing\n\n\t\t\t\t      [5]Back");

                    System.out.print("\n\n\n\tEnter an option to continue -> ");
                    int op3 = input.nextInt();


                if(op3 == 1) {
                    System.out.println("\n\n\n\n\n\n\t\t\t   _____            _     _______");
                    System.out.println("\t\t\t  |  __ \\          | |   |__   __|");
                    System.out.println("\t\t\t  | |__) |___ _ __ | |_     | | __ ___  __");
                    System.out.println("\t\t\t  |  _  // _ \\ '_ \\| __|    | |/ _` \\ \\/ /");
                    System.out.println("\t\t\t  | | \\ \\  __/ | | | |_     | | (_| |>  <");
                    System.out.println("\t\t\t  |_|  \\_\\___|_| |_|\\__|    |_|\\__,_/_/\\_\\");
                    System.out.println("\t\t\t  =========================================");

                    System.out.print("\n\n\n\t\t\t\tEnter your Rent : Rs.");
                    double rent = input.nextDouble();

                    double rentTaxRate, rentTax;

                    if(rent < 100000) {
                        System.out.println("\n\n\n\t\t\t\t\tYou are not required to pay Rent Tax.");
                    } else {
                        rentTaxRate = 5;

                        rentTax = rent * rentTaxRate/100;
                        String strRentTax = String.format("%.2f", rentTax);

                        System.out.println("\n\n\n\t\t\t\tYou have to pay Rent Tax : Rs." + strRentTax);
                    }
                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }
                }
                if(op3 == 2) {
                    System.out.println("\n\n\n\n\n\n\t\t    _____                                 _______");
                    System.out.println("\t\t   |_   _|                               |__   __|");
                    System.out.println("\t\t     | |  _ __   ___ ___  _ __ ___   ___    | | __ ___  __");
                    System.out.println("\t\t     | | | '_ \\ / __/ _ \\| '_ ` _ \\ / _ \\   | |/ _` \\ \\/ /");
                    System.out.println("\t\t    _| |_| | | | (_| (_) | | | | | |  __/   | | (_| |>  <");
                    System.out.println("\t\t   |_____|_| |_|\\___\\___/|_| |_| |_|\\___|   |_|\\__,_/_/\\_\\");
                    System.out.println("\t\t   ========================================================");

                    System.out.print("\n\n\n\t\t\tEnter your total income per year : Rs.");
                    double totalIncome = input.nextDouble();

                    double incomeTaxRate, incomeTax;

                    if(totalIncome <= 1200000) {
                        System.out.println("\n\n\n\t\t\t\tYou are not required to pay Income Tax.");
                    } else if(totalIncome > 1200000 && totalIncome <= 1700000) {
                        incomeTaxRate = 6;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else if(totalIncome > 1700000 && totalIncome <= 2200000) {
                        incomeTaxRate = 12;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else if(totalIncome > 2200000 && totalIncome <= 2700000) {
                        incomeTaxRate = 18;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else if(totalIncome > 2700000 && totalIncome <= 3200000) {
                        incomeTaxRate = 24;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else if(totalIncome > 3200000 && totalIncome <= 3700000) {
                        incomeTaxRate = 30;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else if(totalIncome > 3700000) {
                        incomeTaxRate = 36;

                        incomeTax = totalIncome * incomeTaxRate/100;
                        String strIncomeTax = String.format("%.2f", incomeTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Income Tax per year : Rs." + strIncomeTax);
                    } else {
                        System.out.println("\n\n\n\t\t\t\tOops! Something went wrong.");
                    }
                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }

                }
                if(op3 == 3) {
                    System.out.println("\n\n\n\n\n\n\t\t    _____                  _     _        _______");
                    System.out.println("\t\t   |  __ \\                | |   | |      |__   __|");
                    System.out.println("\t\t   | |__) |_ _ _   _  __ _| |__ | | ___     | | __ ___  __");
                    System.out.println("\t\t   |  ___/ _` | | | |/ _` | '_ \\| |/ _ \\    | |/ _` \\ \\/ /");
                    System.out.println("\t\t   | |  | (_| | |_| | (_| | |_) | |  __/    | | (_| |>  <");
                    System.out.println("\t\t   |_|   \\__,_|\\__, |\\__,_|_.__/|_|\\___|    |_|\\__,_/_/\\_\\");
                    System.out.println("\t\t                __/ |");
                    System.out.println("\t\t               |___/");
                    System.out.println("\t\t   ========================================================");

                    System.out.print("\n\n\n\t\t\tEnter your employee payment per month : Rs.");
                    double payment = input.nextDouble();

                    double payableTaxRate, payableTax;

                    if(payment <= 100000) {
                        System.out.println("\n\n\n\t\t\t\tYou are not required to pay Payable Tax.");
                    } else if(payment > 100000 && payment <= 141667) {
                        payableTaxRate = 6;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else if(payment > 141667 && payment <= 183333) {
                        payableTaxRate = 12;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else if(payment > 183333 && payment <= 225000) {
                        payableTaxRate = 18;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else if(payment > 225000 && payment <= 266667) {
                        payableTaxRate = 24;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else if(payment > 266667 && payment <= 308333) {
                        payableTaxRate = 30;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else if(payment > 308333) {
                        payableTaxRate = 36;

                        payableTax = payment * payableTaxRate/100;
                        String strPayableTax = String.format("%.2f", payableTax);

                        System.out.println("\n\n\n\t\t\tYou have to pay Payable Tax per month : Rs." + strPayableTax);
                    } else {
                        System.out.println("\n\n\n\t\t\t\tOops! Something went wrong.");
                    }
                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }

                }
                if(op3 == 4) {
                    System.out.println("\n\n\n\n\n\n\t\t\t    _                    _");
                    System.out.println("\t\t\t   | |                  (_)");
                    System.out.println("\t\t\t   | |     ___  __ _ ___ _ _ __   __ _");
                    System.out.println("\t\t\t   | |    / _ \\/ _` / __| | '_ \\ / _` |");
                    System.out.println("\t\t\t   | |___|  __/ (_| \\__ \\ | | | | (_| |");
                    System.out.println("\t\t\t   |______\\___|\\__,_|___/_|_| |_|\\__, |");
                    System.out.println("\t\t\t                                  __/ |");
                    System.out.println("\t\t\t                                 |___/");
                    System.out.println("\t\t\t   ====================================");

                    System.out.print("\n\n\n\t\tEnter the monthly lease payment amount you can afford : Rs.");
                    double lease = input.nextDouble();

                    System.out.print("\n\t\tEnter number of years         : Rs.");
                    int years = input.nextInt();

                    System.out.print("\n\t\tEnter annual interest rate (%): ");
                    int rate = input.nextInt();

                    double leasePayment = lease * rate / (1 - (1 / (1 + rate) * years));
                    String strLeasePayment = String.format("%.2f", leasePayment);

                    System.out.println("\n\n\n\t\tYou can get Lease Amount : Rs." + strLeasePayment);

                    System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                    char sel1 = input.next().charAt(0);

                    if (sel1 == 'y'){
                        flag = true;
                    } else if (sel1 == 'n') {
                        return;
                    }
                }
                if(op3 == 5) { break; }
                else if (op3 < 1 || op3 > 5) {
                    return;
                }
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

                System.out.println("\n\n Do you want to go to the main options...?(y / n)");
                char sel1 = input.next().charAt(0);

                if (sel1 == 'y'){
                    flag = true;
                } else if (sel1 == 'n') {
                    return;
                }
            }
            if (op == 5) { return; }
        }
    }
}
