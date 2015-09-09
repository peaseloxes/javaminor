package e20150907.fiche.logic;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/8/15.
 */
public class Sale {
    private static Logger logger = LogManager.getLogger(Sale.class.getName());
    private Basket basket;
    private Bill bill;
    private ScanItemRepository repository;

    public Sale(){
        repository = new ScanItemRepository();
        bill = new Bill();
        basket = new Basket();
    }

    public boolean handleCode(final String code){
        ScanItem item = repository.getItemByCode(code);
        if(item != null){
            basket.addToBasket(item);
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }

    public void finish(){
        bill.print();
        bill = new Bill();
    }

}
