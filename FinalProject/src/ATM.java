import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        // inits
        Scanner sc = new Scanner(System.in);
        Bank theBank = new Bank("Bank of UR MOM");

        // add user to bank
        User aUser = theBank.addUser("John", "Doe", "1234");

        Account newAccount = new Account("checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

            curUser = ATM.mainMenuPrompt(theBank, sc);

            ATM.printUserMenu(curUser, sc);
        }
    }

    private static void printUserMenu(User curUser, Scanner sc) {
        curUser.printAccountSummary();

        int choice;

        do {
            System.out.printf("Welcome %s, what would you like to do?\n", curUser.getFirstName());
            System.out.println("    1) Show account transaction history");
            System.out.println("    2) withdraw");
            System.out.println("    3) deposit");
            System.out.println("    4) Transfer");
            System.out.println("    5) quit \n");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("you idot");
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                ATM.showTransHistory(curUser, sc);
                break;
            case 2:
                ATM.withdraw(curUser, sc);
                break;
            case 3:
                ATM.deposit(curUser, sc);
                break;
            case 4:
                ATM.transfer(curUser, sc);
                break;
            default:
                break;
        }

        if (choice != 5) {
            ATM.printUserMenu(curUser, sc);
        }
    }

    private static void transfer(User curUser, Scanner sc) {
    }

    private static void deposit(User curUser, Scanner sc) {
    }

    private static void withdraw(User curUser, Scanner sc) {
    }

    private static void showTransHistory(User curUser, Scanner sc) {
        int theAcct;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nwhose transaction you want to see : ",
                    curUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if (theAcct < 0 || theAcct >= curUser.numAccounts()) {
                System.out.println("idot");
            }
        } while (theAcct < 0 || theAcct >= curUser.numAccounts());
    }

    private static User mainMenuPrompt(Bank theBank, Scanner sc) {
        String userID;
        String pin;
        User authUser;

        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID : ");
            userID = sc.nextLine();
            System.out.print("Enter pin : ");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("incorrect user ID or pin." + "Please try again.");
            }
        } while (authUser == null);
        return authUser;
    }
}
