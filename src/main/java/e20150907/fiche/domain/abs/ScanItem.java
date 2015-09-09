package e20150907.fiche.domain.abs;

import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.scanitems.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/9/15.
 */
@Getter
@Setter
public abstract class ScanItem {
    private String name;
    private Map<String, String> scanCodes = new HashMap<String, String>();
    private Map<String, String> properties = new HashMap<String, String>();
    private Discount discount;

    public boolean hasDiscount(){
        if(discount == null || discount instanceof DiscountNone){
            return false;
        }
        return true;
    }

    public boolean hasCodeType(final String key){
        for (String k : scanCodes.keySet()) {
            if(k.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean hasCodeValue(final String code){
        for (String k : scanCodes.keySet()) {
            if(scanCodes.get(k).equals(code)){
                return true;
            }
        }
        return false;
    }

    public String getCodeByType(final String key){
        for (String k : scanCodes.keySet()) {
            if(k.equals(key)){
                return scanCodes.get(key);
            }
        }
        return null;
    }

    public boolean hasProperty(final String key){
        for (String k : properties.keySet()) {
            if(k.equals(key)){
                return true;
            }
        }
        return false;
    }

    public String getProperty(final String key){
        for (String k : properties.keySet()) {
            if(k.equals(key)){
                return properties.get(key);
            }
        }
        return null;
    }

    public void addCode(final String name, final String code){
        scanCodes.put(name,code);
    }

    public void addProperties(final String name, final String property){
        properties.put(name,property);
    }

    public double calculatePrice(final int amount){
        double price = 0;

        if(this instanceof Product){
            price = ((Product)this).getPrice(amount);
        }

        return price;
    }

    public double calculateEndDiscount(final double price){
        if(this instanceof Product){
            return 0;
        }
        return discount.getDiscountOn(price,1);
    }
}
