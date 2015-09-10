package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.paymentitems.Cash;
import e20150907.fiche.domain.concrete.paymentitems.Digital;
import e20150907.fiche.domain.concrete.paymentitems.TypeCoupon;
import e20150907.fiche.logic.abs.CashRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class CashRegisterImpl implements CashRegister {
    protected static Logger logger = LogManager.getLogger(CashRegisterImpl.class.getName());
    private Sale sale;
    private List<Sale> sales;

    public CashRegisterImpl(){
        sales = new ArrayList<Sale>();
    }

    // TODO possibly warn if previous sale hasn't finished properly yet?
    @Override
    public void startNewSale(){
        if(sale!=null){
            sales.add(sale);
        }
        sale = new Sale();
    }

    /**
     * Handles any codes scanned by a cashier.
     *
     * Delegates codes to proper handlers.
     *
     * @param code the scanned code
     */
    @Override
    public void scan(final String code){
        sale.handleCode(code);
        //logger.info("Scanned code: "+ code);
    }


    // button on register
    @Override
    public void payWithTypeCoupon(final String type, final double amount){
        sale.handlePayment(new TypeCoupon(type,amount));
    }

    // button on register
    @Override
    public void payWithCash(final double amount){
        sale.handlePayment(new Cash(amount));
    }

    @Override
    public void payWithDigital(double amount) {
        sale.handlePayment(new Digital(amount));
    }

    /**
     * Transaction done, print bill and create a new one.
     */
    @Override
    public void finishUpSale(){
        sale.closeSale();
        // TODO move print decision up to caller
        logger.info("");
        logger.info("");
        sale.finish(true);
    }
}
