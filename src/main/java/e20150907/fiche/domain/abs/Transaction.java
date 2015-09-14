package e20150907.fiche.domain.abs;

/**
 * Created by alex on 9/10/15.
 */
public abstract class Transaction {
    /**
     * Handles a provided code, i.e. from a cash register.
     *
     * @param code the provided code.
     * @return true if handled as expected, false otherwise.
     */
    public abstract boolean handleCode(final String code);

    /**
     * Handles a provided payment, i.e. from a cash register.
     *
     * @param item the provided payment item.
     * @return true if handled as expected, false otherwise.
     */
    public abstract boolean handlePayment(final PaymentItem item);

    /**
     * Calculates totals and subtotals (up to now) incorporated in this transaction.
     *
     * Can safely be called multiple times.
     */
    public abstract void calculate();

    /**
     * Closes the transaction, preparation for finishing.
     *
     * Can safely be called once.
     */
    public abstract void closeTransaction();

    /**
     * Finishes and optionally prints the result of the transaction.
     *
     * @param print if true the result will be printed.
     */
    public abstract void finishTransaction(final boolean print);
}
