package Application;

import Advert.Localization;
import Vehicle.CarState;
import Vehicle.Make;
import java.util.Date;

public class MyQuery {
    public Make CarMake;
    public float Price;
    public int Mileage, YoP;
    public Localization Localization;
    public CarState CarState;
    public Date AdvertDate;
    
    public MyQuery() {}
    public MyQuery(Make carMake  ) {
        this(carMake, -1);
    }
    public MyQuery(Make carMake, float price  ) {
        this(carMake, price, -1);
    }
    public MyQuery(Make carMake, float price, int mileage  ) {
        this(carMake, price, mileage, -1);
    }
    public MyQuery(Make carMake, float price, int mileage, int yop  ) {
        this(carMake, price, mileage, yop, null);
    }
    public MyQuery(Make carMake, float price, int mileage, int yop, Localization localization ) {
        this(carMake, price, mileage, yop, localization, null);
    }
    public MyQuery(Make carMake, float price, int mileage, int yop, Localization localization, CarState carState) {
        this(carMake, price, mileage, yop, localization, carState, null);
    }
    public MyQuery(Make carMake, float price, int mileage, int yop, Localization localization, CarState carState, Date advDate) {
        this.CarMake = carMake;
        this.Price = price;
        this.Mileage = mileage;
        this.YoP = yop;
        this.Localization = localization;
        this.CarState = carState;
        this.AdvertDate = advDate;
    }
}
