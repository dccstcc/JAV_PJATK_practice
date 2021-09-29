package Advert;

import Vehicle.Car;
import Vehicle.CarState;
import java.util.Date;

public class Advert {
    public final Date Date;
    public float Price;
    public final Car Car;
    public Localization Localization;
    public CarState CarState;
    
    public Advert(Car car, float price, Localization localization, CarState state) {
        this.Date = new Date();
        this.Car = car;
        this.Price = price;
        this.Localization = localization;
        this.CarState = state;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "{Advert: Date: " + this.Date.toLocaleString() + ".\n" + 
                Car.toString() + "\n\tState: " + this.CarState + ".\n" +
                        "For " + this.Price + " PLN in " + this.Localization.toString() +
                        "}";
                
        return str;
    }
    
    
}
