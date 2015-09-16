package e20150907.fiche.domain.abs;

import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.domain.concrete.transactions.TransactionState;
import e20150907.fiche.logic.ScanItemRepository;
import e20150907.fiche.util.PreferenceUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/10/15.
 */
@Getter
@Setter
public abstract class Transaction {
    private static Logger logger = LogManager.getLogger(Transaction.class.getName());

    private Bill bill;
    private TransactionState state;
    private ScanItemRepository repository;
    private Basket basket;

    private double totalPrice;
    private double totalPriceRemaining;

    private Map<String, Double> pricePerCategory;
    private Map<String, Double> priceRemainingPerCategory;

    public Transaction() {
        state = TransactionState.OPENED;

        bill = new Bill();
        repository = new ScanItemRepository();
        basket = new Basket();

        pricePerCategory = new HashMap<>();
        priceRemainingPerCategory = new HashMap<>();

        // populate
        for (String category : PreferenceUtil.getPRICING_CATEGORIES()) {
            pricePerCategory.put(category, new Double(0));
            priceRemainingPerCategory.put(category, new Double(0));
        }

        state = TransactionState.MUTATING;
    }

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
     * <p>
     * Can safely be called multiple times.
     */
    public abstract void calculate();

    /**
     * Closes the transaction, preparation for finishing.
     * <p>
     * Can safely be called once.
     */
    public abstract void closeTransaction();

    /**
     * Finishes and optionally prints the result of the transaction.
     *
     * @param print if true the result will be printed.
     */
    public abstract void finishTransaction(final boolean print);

    /**
     * Returns a ScanItem given a valid identity code.
     *
     * @param code the code to search for.
     * @return the corresponding ScanItem or null if not found
     */
    protected final ScanItem getItemByCode(final String code) {
        return repository.getItemByCode(code);
    }

    /**
     * Adds an item to the basket.
     *
     * @param code an identifying code of the item to add.
     * @return true if added, false otherwise
     */
    protected final boolean addItemToBasket(final String code) {
        return addItemToBasket(getItemByCode(code));
    }

    /**
     * Adds an item to the basket.
     *
     * @param item the item to add.
     * @return true if added, false otherwise
     */
    protected final boolean addItemToBasket(final ScanItem item) {
        if (state == TransactionState.MUTATING) {
            return basket.addToBasket(item);
        }
        logger.error("Can not add items to this transaction, it is no longer in the correct state.");
        return false;
    }

    protected final boolean payWithItem(final PaymentItem item) {
        if (state != TransactionState.CLOSED & state != TransactionState.PAID) {
            state = TransactionState.PAYING;

            // TODO move implementation from sale to here

        }

        // if everything was paid, state changes to PAID
        if (totalPriceRemaining < 0) {
            state = TransactionState.PAID;
        }
        return false;
    }
}
