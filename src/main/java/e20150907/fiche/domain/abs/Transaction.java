package e20150907.fiche.domain.abs;

/**
 * Created by alex on 9/10/15.
 */
public abstract class Transaction {
    public abstract boolean handleCode(final String code);
    public abstract boolean handlePayment(final PaymentItem item);
    public abstract void calculate();
    public abstract void closeTransaction();
    public abstract void finishTransaction(final boolean print);
}
