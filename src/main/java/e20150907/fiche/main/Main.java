package e20150907.fiche.main;

import e20150907.fiche.domain.PaymentType;
import e20150907.fiche.logic.CashRegister;

/**
 * Created by alex on 9/7/15.
 */
public class Main {
    public static void main(String[] args){


        CashRegister register1 = new CashRegister();

        register1.scan("barcode1");
        register1.scan("barcode1");
        register1.scan("barcode1");
        register1.scan("customcode3");
        register1.scan("digit2");
        register1.scan("barcode1");
        register1.scan("barcode4");
        register1.paymentType(PaymentType.CREDITCARD);
        register1.ding();

    }
}
