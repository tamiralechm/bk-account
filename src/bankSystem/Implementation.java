package bankSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Implementation {

    private static Map<String, AccountInfo> accounts = new HashMap<>();

    // 5. cash withdrawal operation
    public static void withdrawCash() {
        // Open Scanner and close it automatically, try-with-resources
        try (Scanner scan = new Scanner(System.in);) {
            System.out.print("Enter your account number: ");
            String withdrawalAccount = scan.next();
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scan.nextDouble();
            System.out.println("Processing withdrawal....");
            System.out.println("Checking your account and available balance....");
            AccountInfo registeredAccount = accounts.get(withdrawalAccount);// get the account if it exists
            if (registeredAccount != null) {
                double availableBalance = registeredAccount.getBalance(); // get the available balance in z registered
                                                                          // account
                if (availableBalance >= withdrawalAmount) {
                    registeredAccount.setBalance(availableBalance - withdrawalAmount);
                    accounts.put(withdrawalAccount, registeredAccount);
                    // accounts.put(withdrawalAccount,
                    // registeredAccount).setBalance(availableBalance - withdrawalAmount);
                    System.out
                            .println("Withdrawal completed successfully!!, your balance has been updated: " + accounts);
                } else if (availableBalance < withdrawalAmount) {
                    System.out.println("Insufficient balance!! please modify the withdrawal amount.");
                } else {
                    System.out.println("Error has occurred!! check your account");
                }
            }
        }
        // you can add catch here, but is not obligatory
        // resources like Scanner can be closed in 2 ways,
        // 1. try-with-resources
        // 2. try with finally
//        try {
//            
//        } finally {
//            if(scan != null) scan.close();
//        }
    }

    // 4. cash deposit menu option
    public static void cashDeposit() {
        try (Scanner scan = new Scanner(System.in);) {
            System.out.println("Enter your account number");
            String depositAccount = scan.next();
            System.out.println("Please provide the deposit amount: ");
            double depositAmount = scan.nextDouble();
            System.out.println("Processing cash deposit...");
            AccountInfo registeredAccount = accounts.get(depositAccount);
            if (registeredAccount != null) {
                registeredAccount.setBalance(registeredAccount.getBalance() + depositAmount); // update account balance
                accounts.put(registeredAccount.getAccountNumber(), registeredAccount); // save the updated value in the
                System.out.print("Cash deposited successfully!!");
                System.out.println("\n your account balance has been updated: " + registeredAccount);
            } else {
                System.out.println("The deposit account is not found!!!");
            }
        }
    }

    // 3. search account by its number,key of the accountInfo hash map
    public static void searchAccount() {
        try (Scanner scan = new Scanner(System.in);) {
            System.out.print("please provide the account number: ");
            String accSearch = scan.next();
            boolean found = accounts.containsKey(accSearch); // getAccountNumber;check if it exists
            System.out.println("Searching for your account number....");
            if (found == true) {
                System.out.println("Here is your search result: " + accounts.get(accSearch));
            } else {
                System.out.println("Sorry, the account number is not found!!!");
            }
        }
    }

    // 1 create account using AccountInfo class attributes
    public static void createAccount() {
        try (Scanner scan = new Scanner(System.in);) {
            AccountInfo acc = new AccountInfo();
            System.out.println("Please provide account details");
            System.out.print("Eneter first name: ");
            acc.setfirstName(scan.next());
            System.out.print("Eneter last name: ");
            acc.setLastName(scan.next());
            System.out.print("please eneter account number: ");
//            String newAct = scan.next();
//            boolean existingAcctNum = accounts.containsKey(newAct); // getAccountNumber;check if it exists
//            if (existingAcctNum) {
//                System.out.println("account number already exists, choose another one");
//            }else {
//                acc.setAccountNumber(newAct);
//                System.out.print("please provide initial balance: ");
//                acc.setBalance(scan.nextDouble());
//                accounts.put(acc.getAccountNumber(), acc);
//                }
//            return;
            boolean existingAcctNum = false;
            String accNumber;
            for (int i = 0; i < 3; i++) {
                accNumber = scan.next();
                existingAcctNum = accounts.containsKey(accNumber);
                if (!existingAcctNum) {
                    acc.setAccountNumber(accNumber);
                    System.out.print("please provide initial balance: ");
                    acc.setBalance(scan.nextDouble());
                    accounts.put(acc.getAccountNumber(), acc);
                    break;
                }
                System.out.println("account number already exists, choose another one");
            }
        }
    }

    // menu options of the whole banking services
    public static int menuImpl() {
        int menuList;
        try (Scanner scan = new Scanner(System.in);) {
            System.out.println("*****Main menu*****");
            System.out.println("1-Create account");
            System.out.println("2-Display All registered account informations");
            System.out.println("3-Search Account");
            System.out.println("4-Deposit Cash");
            System.out.println("5-Withdraw Cash");
            System.out.println("6-Exit");
            menuList = scan.nextInt();
            return menuList;
        }
    }

    public static void main(String[] args) {
        while (true) {
            int menu = menuImpl();
            switch (menu) {
            case 1:
                System.out.println("You are about to create a new account ....");
                createAccount();
                break;
            case 2:
                System.out.println("You chose to see registered accounts");
                if (accounts.isEmpty() == false) {
                    System.out.print("Displaying all registered accounts....");
                    System.out.println(accounts);
                } else {
                    System.out.println("Sorry!!the list is empty,nothing to display");
                }

                break;
            case 3:
                searchAccount();
                break;
            case 4:
                System.out.println("Proceeding to depositing operation...");
                cashDeposit();
                break;
            case 5:
                System.out.println("You chose to make a withdrawal");
                withdrawCash();
                break;
            case 6:
                System.out.println("You chose to exit from the system\n exiting....");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");

            }
        }

    }

}
