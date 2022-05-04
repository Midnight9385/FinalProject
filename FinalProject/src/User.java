import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    /**
     * the first name of the user
     */
    private String firstName;
    /**
     * the last name of the user
     */
    private String lastName;
    /**
     * The ID number of the user
     */
    private String uuid;
    /**
     * the MD5 hash of the users pin number
     */
    private byte pinHash[]; 
    /**
     * list of accounts for the user
     */
    private ArrayList<Account> accounts;
    /**
     * create a new user
     * @param firstName user's first name
     * @param lastName  user's last name
     * @param pin the user's account pin number
     * @param theBank the Bank the user is a customer of
     */
    public User(String firstName, String lastName, String pin, Bank theBank){
        this.firstName = firstName;
        this.lastName = lastName;
         
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught noSuchAlgorithimException");
            e.printStackTrace();
            System.exit(1);
        } 

        this.uuid = theBank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();

        System.out.printf("New user %s, %s with ID %s created.\n", lastName,firstName,this.uuid);
    }
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}
