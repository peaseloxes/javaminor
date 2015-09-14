package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.abs.ScanItem;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/9/15.
 */
@Getter
@Setter
public class Basket {
    private static Logger logger = LogManager.getLogger(Basket.class.getName());
    private Map<ScanItem,Integer> scannedItems;
    private Discount endDiscount;
    public Basket(){
        scannedItems = new HashMap<ScanItem,Integer>();
    }

    public double calculateTotalPrice(){
        double total = 0;
        double discount = 0;
        for (ScanItem scanItem : scannedItems.keySet()) {
            total+= scanItem.calculatePrice(scannedItems.get(scanItem));
        }
        for (ScanItem scanItem : scannedItems.keySet()) {

            // if the scan item offers a discount
            if (scanItem.calculateEndDiscount(total) > 0){

                // last end discount counts
                discount = scanItem.calculateEndDiscount(total);
                endDiscount = scanItem.getDiscount();
            }
        }
        if(discount!=0){
            return discount;
        }
        return total;
    }

    public boolean addToBasket(final ScanItem item){
        if(scannedItems.containsKey(item)){
            scannedItems.put(item, scannedItems.get(item) + 1);
        }else{
            scannedItems.put(item,1);
        }
        return true;
    }

    public double calculatePriceForItemsWithProperty(final String property, final String value){
        double total = 0;
        for (ScanItem scanItem : scannedItems.keySet()) {
            if(scanItem.hasProperty(property) && scanItem.getProperty(property).equals(value)){
                int amount = scannedItems.get(scanItem);
                double v = scanItem.calculatePrice(amount);
                total += v;
            }
        }
        if(endDiscount==null){
            return total;
        }
        return endDiscount.getDiscountOn(total,1);
    }
}
