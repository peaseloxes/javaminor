package e20150907.fiche.domain.concrete;

/**
 * Created by alex on 9/7/15.
 */
public enum PaymentType {
    CREDITCARD("Credit Card"),
    CHEQUE("Cheque"),
    GIFTCARD("Gift Card");
    private final String desc;

    private PaymentType(String desc){
        this.desc = desc;
    }

    @Override
    public String toString(){
        return desc;
    }
}
