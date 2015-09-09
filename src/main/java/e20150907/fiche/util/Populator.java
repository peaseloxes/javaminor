package e20150907.fiche.util;

import e20150907.fiche.domain.concrete.*;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.discounts.DiscountOnAmount;
import e20150907.fiche.domain.concrete.discounts.DiscountPercentage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/8/15.
 */
public class Populator {
    private List<String> randomStrings;

    @Getter
    private List<Product> productList;
    @Getter
    private List<Customer> customerList;

    public void populate(){
        randomStrings  = new ArrayList<String>();
        productList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
        generateDummyProducts(15);
        generateDummyCustomers(5);
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

            ProductID id = new ProductID()
                    .addCode("barcode","b"+getUniqueRandomString())
                    .addCode("customcode","c"+getUniqueRandomString())
                    .addCode("digitcode","d"+getUniqueRandomString());
            product.setIdentifier(id);

            ProductPrice price = new ProductPrice(NumUtil.getRandomDouble(500));


            if(NumUtil.fiftyfifty()){
                // fixed discount capped on initial price
                int basePrice = ((Number)price.getBasePrice()).intValue();
                price.setDiscount(new DiscountFixedAmount(NumUtil.getRandomInt(basePrice)));
            }else if(NumUtil.fiftyfifty()){
                // variable discount capped on 50 percent
                price.setDiscount(new DiscountPercentage(NumUtil.getRandomInt(50)));
            }else if(NumUtil.fiftyfifty()) {
                // buy x get y free discount
                price.setDiscount(new DiscountOnAmount(NumUtil.getRandomInt(10)+1,NumUtil.getRandomInt(2)+1));
            }else {
                price.setDiscount(new DiscountNone());
            }

            product.setPrice(price);
            productList.add(product);
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
            fidelityCard.setCode("FC" + getUniqueRandomString());

            // max 50% discount
            fidelityCard.setDiscount(new DiscountPercentage(NumUtil.getRandomInt(50)));

            customer.setCard(fidelityCard);

            customerList.add(customer);
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
    public List<Product> getRandomSelectionFromProductList(final int maxItems){
        List<Product> randomList = new ArrayList<Product>();
        for (int i = 0; i < maxItems; i++) {
            Product random = productList.get(NumUtil.getRandomInt(productList.size()));
            if(!randomList.contains(random)){
                randomList.add(random);
            }
        }
        return randomList;
    }

    public Customer getRandomCustomer() {
        return customerList.get(NumUtil.getRandomInt(customerList.size()));
    }
}
