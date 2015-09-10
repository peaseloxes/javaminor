package e20150907.fiche.domain.concrete.transactions;

import e20150907.fiche.domain.abs.Transaction;

/**
 * Created by alex on 9/10/15.
 */
public class Reservation extends Transaction {

    @Override
    public boolean handleCode(String code) {
        return false;
    }

    @Override
    public void calculate() {

    }
}
