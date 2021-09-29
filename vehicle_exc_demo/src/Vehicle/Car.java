
package Vehicle;

import java.util.Date;

public class Car {
    public final Make Make;
    public final int Mileage,
            YearOfProduction;
    
    public Car(Make make) {
        this(make, 0, new Date().getYear());
    }
    public Car(Make make, int mileage, int yop) {
        this.Make = make;
        this.Mileage = mileage;
        this.YearOfProduction = yop;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "\tMake: " + this.Make + ",\n\tYoP: " + this.YearOfProduction + 
                ",\n\tMileage: " + this.Mileage + ",";
       
        return str;
    }
}
