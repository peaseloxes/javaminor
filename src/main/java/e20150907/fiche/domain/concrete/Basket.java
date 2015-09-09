package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.ScanItem;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/9/15.
 */
@Getter
@Setter
public class Basket {
    private Map<ScanItem,Integer> scannedItems;

    public Basket(){
        scannedItems = new HashMap<ScanItem,Integer>();
    }

    public double calculateTotalPrice(){
        double total = 0;
        for (ScanItem scanItem : scannedItems.keySet()) {
            total+= scanItem.calculatePrice(scannedItems.get(scanItem));
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
                total += scanItem.calculatePrice(scannedItems.get(scanItem));
            }
        }
        return total;
    }
}
