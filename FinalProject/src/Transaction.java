import java.util.Date;

public class Transaction {
    /**
     * amount of this transaction
     */
    private double amount;
    /**
     * the time and date of this transaction
     */
    private Date timestamp;
    /**
     * A memo for this transaction
     */
    private String memo;
    /**
     * the account in which the transaction was performed
     */
    private Account inAccount;
    /**
     * create new transaction without message
     * @param amount
     * @param inAccount
     */
    public Transaction(double amount, Account inAccount){
        this.amount=amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
    }
    /**
     * create new transaction with message
     * @param amount
     * @param inAccount
     * @param memo
     */
    public Transaction(double amount, Account inAccount, String memo){
        this(amount, inAccount);
        this.memo = memo;
    }
}
