package e20150907.fiche.main;

import e20150907.fiche.domain.concrete.Customer;
import e20150907.fiche.domain.concrete.PaymentType;
import e20150907.fiche.domain.concrete.Product;
import e20150907.fiche.logic.CashRegister;
import e20150907.fiche.logic.ProductFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class Main {
    private static Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args){

        // for test data only, get 10 random products
        List<Product> randomProducts = ProductFactory.getPopulator().getRandomSelectionFromProductList(10);
        Customer randomCustomer = ProductFactory.getPopulator().getRandomCustomer();

        CashRegister register1 = new CashRegister();

        // three product 1's
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));

        // product with a custom code
        register1.scan(randomProducts.get(2).getIdentifier().getCodes().get("customcode"));

        // product with a digit code
        register1.scan(randomProducts.get(3).getIdentifier().getCodes().get("digitcode"));

        // another product 1 popped up
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));

        // scanned a fidelity card (10% discount)
        register1.scan(randomCustomer.getCard().getCode());

        // one last product, 4
        register1.scan(randomProducts.get(4).getIdentifier().getCodes().get("barcode"));

        // payment type set to credit card
        register1.setPaymentType(PaymentType.CREDITCARD);

        // do the finishing up
        register1.ding();

        // prove items were saved
        logger.info(randomCustomer.getCard().getProductHistory().size() + " purchase(s) made by this customer!");

        logger.info("");
        logger.info("");

        // same customer going for another round

        register1 = new CashRegister();

        // three product 1's
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("customcode"));
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("digitcode"));

        // product with a custom code
        register1.scan(randomProducts.get(2).getIdentifier().getCodes().get("customcode"));

        // product with a digit code
        register1.scan(randomProducts.get(3).getIdentifier().getCodes().get("digitcode"));

        // another product 1 popped up
        register1.scan(randomProducts.get(1).getIdentifier().getCodes().get("barcode"));

        // scanned a fidelity card (10% discount)
        register1.scan(randomCustomer.getCard().getCode());

        // one last product, 4
        register1.scan(randomProducts.get(4).getIdentifier().getCodes().get("barcode"));

        // payment type set to cheque
        register1.setPaymentType(PaymentType.CHEQUE);

        // do the finishing up
        register1.ding();

        // prove items were saved
        logger.info(randomCustomer.getCard().getProductHistory().size() + " purchase(s) made by this customer!");
    }
}
