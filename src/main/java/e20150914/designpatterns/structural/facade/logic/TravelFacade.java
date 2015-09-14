package e20150914.designpatterns.structural.facade.logic;

import e20150914.designpatterns.structural.facade.domain.Flight;
import e20150914.designpatterns.structural.facade.domain.Hotel;

/**
 * Created by alex on 9/14/15.
 */
public class TravelFacade {

    public String getFlightToHotel(String hotel){
        for (int i = 0; i < Hotel.getHotels().length; i++) {
            if(Hotel.getHotels()[i].equals(hotel)){
                return Flight.getFlights()[i] + " flies to " + hotel;
            }
        }
        return "No flights found";
    }
}
