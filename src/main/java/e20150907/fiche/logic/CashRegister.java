package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.domain.concrete.Customer;
import e20150907.fiche.domain.concrete.PaymentType;
import e20150907.fiche.domain.concrete.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class CashRegister {
    protected static Logger logger = LogManager.getLogger(CashRegister.class.getName());
    private Bill bill;
    private List<Product> productList;
    private List<Customer> customerList;

    public CashRegister(){
        productList = ProductFactory.getProductList();
        customerList = ProductFactory.getCustomerList();
        bill = new Bill();
    }

    /**
     * Handles any codes scanned by a cashier.
     *
     * Delegates codes to proper handlers.
     *
     * @param code the scanned code
     */
    public boolean scan(final String code){
        if(handleProductCode(code)){
            return true;
        }
        if(handleFidelityCard(code)){
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }

    /**
     * Checks the given code against known fidelity cards and handles it accordingly.
     *
     * @param code the code to check
     * @return true if found and handled, false otherwise
     */
    public boolean handleFidelityCard(final String code){
        for (Customer customer : customerList) {
            if(customer.getCard().codeMatches(code)){
                bill.setCustomerDiscountPercentage(customer.getCard().getDiscountPercentage());

                // only one customer possible, so return to inform caller the customer was found
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the given code against known products and handles it accordingly.
     *
     * @param code one of the product identifier codes
     * @return true if found and handled, false otherwise
     */
    public boolean handleProductCode(final String code){

        List<Product> found = new ArrayList<Product>();

        for (Product product : productList) {
            Product possibleMatch = product.hasId(code);
            if(possibleMatch!=null){
                found.add(possibleMatch);
            }
        }

        // more than one product found
        if(found.size() > 1){
            logger.error("More than one product matches an id for " + code);
            logger.error("Product was not added.");
            for (Product product : found) {
                logger.error(product);
            }

            // nothing can be done, return false to inform caller nothing happened
            return false;
        }

        // less than one product found
        if (found.size() < 1){
            // no error messages, no product found, but code might not be meant for this method
            // return false to inform caller nothing happened
            return false;
        }

        bill.addProduct(found.get(0),1);

        // product was added, inform caller everything went fine
        return true;
    }

    /**
     * Sets the payment type to be displayed on bill.
     *
     * Currently only prints the type.
     *
     * @param type the payment type
     */
    public void setPaymentType(final PaymentType type){
        bill.setPaymentType(type);
    }

    /**
     * Transaction done, print bill and create a new one.
     */
    public void ding(){
        bill.print();
        bill = new Bill();
    }
}
