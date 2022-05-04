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
}
