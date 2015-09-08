package e20150907.fiche.domain.concrete;

import e20150907.fiche.logic.ProductFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/8/15.
 */
public class Sale {
    private static Logger logger = LogManager.getLogger(Sale.class.getName());
    private Bill bill;
    private List<Product> productList;
    private List<Customer> customerList;

    public Sale(){
        productList = ProductFactory.getProductList();
        customerList = ProductFactory.getCustomerList();
        bill = new Bill();
    }
    public boolean handleCode(final String code){
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
                bill.setCustomer(customer);
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

        bill.addProduct(found.get(0), 1);

        // product was added, inform caller everything went fine
        return true;
    }

    public void finalize(){
        bill.print();
        bill = new Bill();
    }

    public void setPaymentType(PaymentType paymentType) {
        bill.setPaymentType(paymentType);
    }
}
