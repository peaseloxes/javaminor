package e20150907.fiche.domain.concrete;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/8/15.
 */
@Getter
@Setter
public class FidelityCard {
    private String code;
    private int discountPercentage;

    public boolean codeMatches(final String codeToCheck){
        if(code.equals(codeToCheck)){
            return true;
        }
        return false;
    }
}
