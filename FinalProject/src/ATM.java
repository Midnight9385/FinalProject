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
    }

    private static User mainMenuPrompt(Bank theBank, Scanner sc) {
        return null;
    }
}
