
package zadanie.pkg1;

import Advert.Advert;
import Advert.Localization;
import Advert.Province;
import Application.App;
import Application.MyQuery;
import Vehicle.CarState;
import Vehicle.Make;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Zadanie1 {
    public static void main(String[] args) {
                
        App app = new App();
        DisplayAdverts(app.GetAllAdverts());
        DisplayAdverts(app.GetAdvertByQuery(SetQuery()));
        
    }
    public static void DisplayAdverts(Set<Advert> adverts) {
        for(Advert adv : adverts)
            System.out.println("\n" + adv.toString());
    }
    public static MyQuery SetQuery() {
        
        // TODO: może jakoś ładniej :D
        MyQuery query = new MyQuery();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Make: ");
        query.CarMake = Make.valueOf(scanner.next());
        System.out.print("Price max: ");
        query.Price = scanner.nextInt();
        System.out.print("Mileage max: ");
        query.Mileage = scanner.nextInt();
        System.out.print("Year of producton min: ");
        query.YoP = scanner.nextInt();
        
        Localization localization = new Localization();
        System.out.print("Province: ");
        localization.Province = Province.valueOf(scanner.next());
        System.out.print("City: ");
        localization.City = scanner.next();
        query.Localization = localization;
        
        System.out.print("State: ");
        query.CarState = CarState.valueOf(scanner.next());
        
        query.AdvertDate = new Date();
        
       
        return query;
    }
    
}
