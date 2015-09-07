package e20150907.fiche.domain.concrete;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/7/15.
 */
@Getter
public class ProductID {
    private Logger logger = LogManager.getLogger(ProductID.class.getName());

    private Map<String, String> codes;

    public ProductID(){
        codes = new HashMap<String, String>();
    }

    public ProductID addCode(final String codeName, final String code){
        if(codes.put(codeName, code) != null){
            logger.warn(codeName + " already exists! Replaced the old value for "+codeName+" with the new value.");
        }
        return this;
    }

    public boolean hasId(final String id){
        for (Map.Entry<String, String> pair : codes.entrySet()){
            if(pair.getValue().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String response = "";
        for (Map.Entry<String, String> pair : codes.entrySet()){
            response += pair.getKey() + ": " + pair.getValue() + "\n";
        }
        return response;
    }
}
