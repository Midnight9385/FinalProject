import java.util.ArrayList;
import java.util.Random;

public class Bank {
    
    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    /**
     * creates new bank
     * @param name name of bank
     */
    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * generate a new uuid for user
     * @return the uuid
     */
    public String getNewUserUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;

        //generate UUID
        do{
            uuid = "";
            for(int c=0; c<len;c++){
                uuid+= ((Integer)rng.nextInt(10)).toString();
            }

            for(User u : this.users){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while(nonUnique);

        return uuid;
    }

    /**
     * generate a new UUID for account
     * @return
     */
    public String getNewAccountUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;
        
        //generate UUID
        do{
            uuid = "";
            for(int c=0; c<len;c++){
                uuid+= ((Integer)rng.nextInt(10)).toString();
            }

            for(Account u : this.accounts){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while(nonUnique);

        return uuid;
    }
    /**
     * adds account to bank
     * @param account account to add
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    /**
     * create a new user of bank
     * @param firstName user's first name
     * @param lastName user's last name
     * @param pin user's pin
     * @return  the new user
     */
    public User addUser(String firstName, String lastName, String pin){
        //create new user
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        //add account to new user
        Account newAccount = new Account(name, newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    /**
     * get user associated with userId and pin
     * @param userID user's UUID
     * @param pin user's pin
     * @return the user
     */
    public User userLogin(String userID, String pin){
        for(User u : this.users){
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
