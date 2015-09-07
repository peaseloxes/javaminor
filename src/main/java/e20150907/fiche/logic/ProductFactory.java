package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class ProductFactory {
    private static List<Product> productList;

    static{
        productList = new ArrayList<Product>();
    }

    public static List<Product> getProductList(){
        return productList;
    }


    /**
     * Generates dummy data to be used by the application.
     */
    public static void generateDummyProducts() {
        Product p1 = new Product();
        p1.setName("Toaster");
        ProductID id1 = new ProductID()
                .addCode("barcode", "barcode1")
                .addCode("customcode", "customcode1")
                .addCode("digitcode", "digit1");
        ProductPrice pr1 = new ProductPrice(49.99).addDiscounts(new DiscountFixed(10));
        p1.setIdentifier(id1);
        p1.setPrice(pr1);

        Product p2 = new Product();
        p2.setName("Microwave");
        ProductID id2 = new ProductID()
                .addCode("barcode", "barcode2")
                .addCode("customcode", "customcode2")
                .addCode("digitcode", "digit2");
        ProductPrice pr2 = new ProductPrice(129).addDiscounts(new DiscountVariable(15));
        p2.setIdentifier(id2);
        p2.setPrice(pr2);

        Product p3 = new Product();
        p3.setName("Phone");
        ProductID id3 = new ProductID()
                .addCode("barcode", "barcode3")
                .addCode("customcode", "customcode3")
                .addCode("digitcode", "digit3");

        // eerst tien eraf, dan 15% korting over restant
        ProductPrice pr3 = new ProductPrice(130.99).addDiscounts(new DiscountFixed(10),new DiscountVariable(15));
        p3.setIdentifier(id3);
        p3.setPrice(pr3);

        // heeft geen custom code label
        Product p4 = new Product();
        p4.setName("Coffeemaker");
        ProductID id4 = new ProductID()
                .addCode("barcode", "barcode4")
                //.addCode("customcode","customcode4")
                .addCode("digitcode","digit4");

        // geen korting
        ProductPrice pr4 = new ProductPrice(21.55);
        p4.setIdentifier(id4);
        p4.setPrice(pr4);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
    }
}
