package e20150907.fiche.domain.concrete;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/8/15.
 */
@Getter
@Setter
public class Customer {
    private long id;
    private String name;
    private FidelityCard card;
}
