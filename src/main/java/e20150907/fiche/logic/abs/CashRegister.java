package e20150907.fiche.logic.abs;

/**
 * Created by alex on 9/10/15.
 */
public interface CashRegister {

    // TODO rework as template pattern?
    // TODO create flowchart
    void openRegister();
    void startNewSale();
    void scan(final String code);
    void payWithTypeCoupon(String type, double amount);
    void payWithCash(double amount);
    void payWithDigital(double amount);
    void finishUpSale();

    void makeReturn(final String code);
    void finishUpReturn();
    void closeRegister();
}
