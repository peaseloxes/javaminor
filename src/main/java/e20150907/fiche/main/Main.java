package e20150907.fiche.main;

import e20150907.fiche.domain.concrete.PaymentType;
import e20150907.fiche.logic.CashRegister;

/**
 * Created by alex on 9/7/15.
 */
public class Main {
    public static void main(String[] args){


        CashRegister register1 = new CashRegister();

        // three product 1's
        register1.scan("barcode1");
        register1.scan("barcode1");
        register1.scan("barcode1");

        // product with a custom code
        register1.scan("customcode3");

        // product with a digit code
        register1.scan("digit2");

        // another product 1 popped up
        register1.scan("barcode1");

        // scanned a fidelity card (10% discount)
        register1.scan("customer1");

        // one last product, 4
        register1.scan("barcode4");

        // payment type set to credit card
        register1.setPaymentType(PaymentType.CREDITCARD);

        // do the finishing up
        register1.ding();

    }
}
