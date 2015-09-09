package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.scanitems.FidelityCard;
import e20150907.fiche.domain.concrete.scanitems.Product;
import junit.framework.TestCase;

/**
 * Created by alex on 9/9/15.
 */
public class BasketTest extends TestCase {

    public void testCalculateTotalPrice() throws Exception {

        Basket basket = new Basket();
        Product p1 = new Product();
        p1.setDiscount(new DiscountNone());
        p1.setPrice(15.0);
        ScanItem i = p1;
        basket.addToBasket(i);
        assertEquals(15.0, basket.calculateTotalPrice());

        p1 = new Product();
        p1.setDiscount(new DiscountFixedAmount(10));
        p1.setPrice(15.0);
        i = p1;
        basket.addToBasket(i);
        assertEquals(20.0, basket.calculateTotalPrice());
    }

    public void testAddToBasket() throws Exception {
        Basket basket = new Basket();
        ScanItem i = new FidelityCard();
        basket.addToBasket(i);
        assertEquals(1,basket.getScannedItems().size());
    }

    public void testCalculatePriceForItemsWithProperty() throws Exception {
        Basket basket = new Basket();
        Product p1 = new Product();
        p1.addProperties("type","ECO");
        p1.setDiscount(new DiscountNone());
        p1.setPrice(15.0);
        ScanItem i = p1;
        basket.addToBasket(i);
        assertEquals(15.0, basket.calculatePriceForItemsWithProperty("type","ECO"));

        p1 = new Product();
        p1.setDiscount(new DiscountFixedAmount(1000000));
        p1.setPrice(1500000.0);
        i = p1;
        basket.addToBasket(i);
        assertEquals(15.0, basket.calculatePriceForItemsWithProperty("type","ECO"));
    }
}