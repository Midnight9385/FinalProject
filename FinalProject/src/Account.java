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
     * 
     * @param name    name of the holer
     * @param holder  user's pin
     * @param theBank bank of user
     */
    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();

        this.Transactions = new ArrayList<Transaction>();

        holder.addAccount(this);
        theBank.addAccount(this);
    }

    /**
     * 
     * @return the accounts uuid
     */
    public String getUUID() {
        return uuid;
    }

    public String getSummary() {
        double balance = this.getBalance();
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : this.Transactions) {
            balance += t.getAmount();
        }
        return balance;
    }
}
