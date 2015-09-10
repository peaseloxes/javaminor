package e20150907.fiche.util;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.discounts.DiscountOnAmount;
import e20150907.fiche.domain.concrete.discounts.DiscountPercentage;
import e20150907.fiche.domain.concrete.scanitems.Customer;
import e20150907.fiche.domain.concrete.scanitems.FidelityCard;
import e20150907.fiche.domain.concrete.scanitems.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/8/15.
 */
public class Populator {
    private List<String> randomStrings;

    @Getter
    private List<ScanItem> scanItemsList;

    @Getter
    private List<ScanItem> fidelityCardList;

    public Populator(){
        populate();
    }

    public void populate(){
        randomStrings  = new ArrayList<String>();
        scanItemsList = new ArrayList<ScanItem>();
        fidelityCardList = new ArrayList<ScanItem>();
        generateDummyProducts(20);
        generateDummyCustomers(5);
    }

    public List<ScanItem> getAllScanItems(){
        List<ScanItem> allItems = new ArrayList<ScanItem>();
        allItems.addAll(scanItemsList);
        allItems.addAll(fidelityCardList);
        return allItems;
    }

    /**
     * Generates a specific amount of products.
     *
     * @param amount the amount to generate
     */
    private void generateDummyProducts(final int amount){

        for (int i = 0; i < amount; i++) {
            Product product = new Product();
            product.setName("Product_" + (i + 1));


            product.addCode("barcode", "b" + getUniqueRandomString());
            product.addCode("customcode", "c" + getUniqueRandomString());
            product.addCode("digitcode", "d" + getUniqueRandomString());

            product.setPrice(NumUtil.getRandomDouble(500));


            if(NumUtil.oneInTen()){
                // fixed discount capped on initial price
                int basePrice = ((Number)product.getPrice()).intValue();
                product.setDiscount(new DiscountFixedAmount(NumUtil.getRandomInt(basePrice)));
            }else if(NumUtil.oneInTen()){
                // variable discount capped on 50 percent
                product.setDiscount(new DiscountPercentage(NumUtil.getRandomInt(50)));
            }else if(NumUtil.oneInTen()) {
                // buy x get y free discount
                product.setDiscount(new DiscountOnAmount(NumUtil.getRandomInt(10)+1,NumUtil.getRandomInt(2)+1));
            }else {
                product.setDiscount(new DiscountNone());
            }

            if(NumUtil.fiftyFifty()){
                String randomType = PreferenceUtil.getPricingCategories()[NumUtil.getRandomInt(PreferenceUtil.getPricingCategories().length)];
                product.addProperties("Type", randomType);
            }else {
                // otherwise no type property
            }

            // application should handle the missing property correctly
            scanItemsList.add(product);
        }
    }

    /**
     * Generates a specific amount of customers.
     *
     * @param amount the amount to generate
     */
    private void generateDummyCustomers(final int amount){
        for (int i = 0; i < amount; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setName("Customer_" + i);

            FidelityCard fidelityCard = new FidelityCard();
            fidelityCard.setName("FidelityCard_" + i);
            // max 20% discount
            fidelityCard.setDiscount(new DiscountPercentage(NumUtil.getRandomInt(20)));
            fidelityCard.addCode("cardcode", "FC" + getUniqueRandomString());

            fidelityCard.setCustomer(customer);
            fidelityCardList.add(fidelityCard);
        }
    }

    /**
     * Creates a unique random string.
     *
     * @return a unique random string
     */
    private String getUniqueRandomString(){
        String randomString = StrUtil.randomString(70);

        while(stringExists(randomString)){
            randomString = StrUtil.randomString(70);
        }
        randomStrings.add(randomString);
        return randomString;
    }

    /**
     * Checks whether or not the string has already been used by the populator.
     *
     * @param string the string to check for
     * @return true if already exists, false otherwise
     */
    private boolean stringExists(final String string){
        for (String randomString : randomStrings) {
            if(randomString.equals(string)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a list with a specified amount of items <b>or less</b>.
     *
     * @param maxItems the maximum amount of items
     * @return a list of random products
     */
    public List<ScanItem> getRandomSelectionFromProductList(final int maxItems){
        List<ScanItem> randomList = new ArrayList<ScanItem>();
        for (int i = 0; i < maxItems; i++) {
            ScanItem random = scanItemsList.get(NumUtil.getRandomInt(scanItemsList.size()));
            if(!randomList.contains(random)){
                randomList.add(random);
            }
        }
        return randomList;
    }

    public ScanItem getRandomFidelityCard() {
        return fidelityCardList.get(NumUtil.getRandomInt(fidelityCardList.size()));
    }

}
