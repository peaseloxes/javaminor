package e20150907.fiche.main;

import e20150907.fiche.domain.abs.ScanItem;
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

    public static void main(String[] args) {

        // for test data only, get 10 random products
        List<ScanItem> randomProducts = ProductFactory.getPopulator().getRandomSelectionFromProductList(10);
        ScanItem randomFidelityCard = ProductFactory.getPopulator().getRandomFidelityCard();

        CashRegister register1 = new CashRegister();

        // three product 1's
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));

        // product with a custom code
        register1.scan(randomProducts.get(2).getCodeByType("customcode"));

        // product with a digit code
        register1.scan(randomProducts.get(3).getCodeByType("digitcode"));

        // another product 1 popped up
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));

        // scanned a fidelity card (10% discount)
        register1.scan(randomFidelityCard.getCodeByType("cardcode"));

        // one last product, 4
        register1.scan(randomProducts.get(4).getCodeByType("barcode"));


        // do the finishing up
        register1.ding();

        // prove items were saved
        //logger.info(randomFidelityCard.getProductHistory().size() + " purchase(s) made by this customer!");

        logger.info("");
        logger.info("");

        // same customer going for another round

        register1 = new CashRegister();

        // eight product 1's
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));

        // product with a custom code
        register1.scan(randomProducts.get(2).getCodeByType("customcode"));

        // product with a digit code
        register1.scan(randomProducts.get(3).getCodeByType("digitcode"));

        // another product 1 popped up
        register1.scan(randomProducts.get(1).getCodeByType("barcode"));

        // scanned a fidelity card (10% discount)
        register1.scan(randomFidelityCard.getCodeByType("cardcode"));

        // one last product, 4
        register1.scan(randomProducts.get(4).getCodeByType("barcode"));

        // do the finishing up
        register1.ding();

        // prove items were saved
        //logger.info(randomFidelityCard.getProductHistory().size() + " purchase(s) made by this customer!");
    }
}
