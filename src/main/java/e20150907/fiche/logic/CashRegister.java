package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.Bill;
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
    protected static Logger log = LogManager.getLogger(CashRegister.class.getName());
    private Bill bill;
    private List<Product> productList;

    public CashRegister(){
        ProductFactory.generateDummyProducts();
        productList = ProductFactory.getProductList();
        bill = new Bill();
    }

    /**
     * Adds a product to a bill based on any identifier code.
     *
     * @param code one of the identifier codes
     */
    public void scan(String code){

        List<Product> found = new ArrayList<Product>();

        for (Product product : productList) {
            Product possible = product.hasId(code);
            if(possible!=null){
                found.add(possible);
            }
        }

        if(found.size() > 1){
            log.error("More than one product matches an id for " + code);
            for (Product product : found) {
                log.error(product);
            }
        }

        if (found.size() < 1){
            log.error("Not one product matches an id for " + code);
        }
        bill.addProduct(found.get(0),1);
    }

    /**
     * Sets the payment type to be displayed on bill.
     *
     * Currently only prints the type.
     *
     * @param type the payment type
     */
    public void setPaymentType(PaymentType type){
        bill.setPaymentType(type);
    }

    /**
     * Transaction done.
     */
    public void ding(){
        bill.print();
    }
}
