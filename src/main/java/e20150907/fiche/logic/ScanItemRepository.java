package e20150907.fiche.logic;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.util.Populator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/9/15.
 */
public class ScanItemRepository {
    private static Logger logger = LogManager.getLogger(ScanItemRepository.class.getName());
    private List<ScanItem> scanItems;
    public ScanItemRepository(){

        // TODO replace when database has been implemented
        Populator populator = ProductFactory.getPopulator();
        scanItems = populator.getAllScanItems();
    }

    public ScanItem getItemByCode(final String code){
        List<ScanItem> found = new ArrayList<ScanItem>();

        for (ScanItem scanItem : scanItems) {
            if(scanItem.hasCodeValue(code)){
                found.add(scanItem);
            }
        }

        // more than one product found
        if(found.size() > 1){
            logger.error("More than one product matches an id for " + code);
            logger.error("Product was not added.");
            found.forEach(logger::error);

            // nothing can be done, return false to inform caller nothing happened
            return null;
        }

        // less than one product found
        if (found.size() < 1){
            logger.error("Not one product matches an id for " + code);
            // no error messages, no product found, but code might not be meant for this method
            // return false to inform caller nothing happened
            return null;
        }


        return found.get(0);
    }
}
