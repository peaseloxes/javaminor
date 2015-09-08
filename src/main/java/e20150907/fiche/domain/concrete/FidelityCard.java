package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/8/15.
 */
@Getter
@Setter
public class FidelityCard {
    private String code;
    private Discount discount;
    private Map<DateTime, Map<Product,Integer>> productHistory;

    public FidelityCard(){
        productHistory = new HashMap<DateTime,Map<Product,Integer>>();
    }

    public void addProductsToHistory(DateTime purchaseDate,Map<Product,Integer> productMap){
        productHistory.put(purchaseDate, productMap);
    }

    public boolean codeMatches(final String codeToCheck){
        if(code.equals(codeToCheck)){
            return true;
        }
        return false;
    }
}
