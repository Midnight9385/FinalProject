import java.util.ArrayList;

public class Account {
    /**
     * the name of the account
     */
    private String name;
    /**
     * the account ID number
     */
    private String uuid;
    /**
     * the User object that owns this account
     */
    private User holder;
    /**
     * the list of transactions for this account
     */
    private ArrayList<Transaction> Transactions;
    /**
     * create new account
     * @param name   name of the holer
     * @param holder user's pin
     * @param theBank bank of user
     */
    public Account(String name, User holder, Bank theBank){
        this.name = name;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();

        this.Transactions = new ArrayList<Transaction>();

        holder.addAccount(this);
        theBank.addAccount(this); 
    }
}
