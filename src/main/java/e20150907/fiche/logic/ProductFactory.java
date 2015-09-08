package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class ProductFactory {
    private static List<Product> productList;
    private static List<Customer> customerList;

    static{
        productList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
    }

    public static List<Product> getProductList(){
        return productList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }


    // TODO move below to proper populator

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

        ProductPrice pr3 = new ProductPrice(130.99).addDiscounts(new DiscountFixed(10),new DiscountVariable(15));
        p3.setIdentifier(id3);
        p3.setPrice(pr3);

        Product p4 = new Product();
        p4.setName("Coffeemaker");
        ProductID id4 = new ProductID()
                .addCode("barcode", "barcode4")
                .addCode("digitcode","digit4");

        ProductPrice pr4 = new ProductPrice(21.55);
        p4.setIdentifier(id4);
        p4.setPrice(pr4);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
    }

    public static void generateDummyCustomers(){
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setName("C. Ustomer");

        FidelityCard f1 = new FidelityCard();
        f1.setCode("customer1");
        f1.setDiscountPercentage(10);
        c1.setCard(f1);

        customerList.add(c1);
    }


}
