package e20150907.fiche.domain;

import lombok.Getter;

/**
 * Created by alex on 9/7/15.
 */
@Getter
public class ProductID {
    private String barCode;
    private String digitCode;
    private String customCode;

    public ProductID setBarcode(final String code){
        this.barCode = code;
        return this;
    }

    public ProductID setDigitcode(final String code){
        this.digitCode = code;
        return this;
    }

    public ProductID setCustomcode(final String code){
        this.customCode = code;
        return this;
    }

    public boolean hasId(final String id){
        if(getBarCode().equals(id)){
            return true;
        }
        if(getCustomCode().equals(id)){
            return true;
        }
        if(getDigitCode().equals(id)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "("+barCode + " / " + digitCode + " / " + customCode + ")";
    }
}
