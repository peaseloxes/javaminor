package e20150907.fiche.logic;

import e20150907.fiche.domain.Bill;
import e20150907.fiche.domain.PaymentType;
import e20150907.fiche.domain.Product;
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
     * Adds a product to a bill based on any identifier code;
     * @param code
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

    public void paymentType(PaymentType type){
        bill.setPaymentType(type);
    }

    public void ding(){
        bill.print();

    }
}
