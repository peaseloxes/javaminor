package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.scanitems.Customer;
import e20150907.fiche.domain.concrete.scanitems.Product;
import e20150907.fiche.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class Bill {
    private Logger logger = LogManager.getLogger(Bill.class.getName());


    private Map<ScanItem, Integer> scanItemsMap;
    private Customer customer;
    private Discount discount;
    private Double totalPrice;
    private Map<String,Double> totalCategoryPrices;

    public Bill(){
        scanItemsMap = new HashMap<ScanItem, Integer>();
    }

    /**
     * Add a product to be billed.
     *
     * @param product the product to add
     * @param amount the amount purchased
     */
    public void addProduct(final Product product, final int amount){
        if(scanItemsMap.containsKey(product)){
            scanItemsMap.put(product, scanItemsMap.get(product) + amount);
        }else{
            scanItemsMap.put(product,amount);
        }
    }

    /**
     * Print the bill to the logger.
     */
    public void print(){
        for (ScanItem k : scanItemsMap.keySet()) {
            logger.info(k.toString() + " X " +scanItemsMap.get(k));
        }
        logger.info("=================================");
        logger.info("Total Price: " + StrUtil.twoDecimal(totalPrice));
        logger.info("Categories: ");
        for(String type : totalCategoryPrices.keySet()){
            logger.info("\t"+type + ": " + StrUtil.twoDecimal(totalCategoryPrices.get(type)));
        }
    }

}
