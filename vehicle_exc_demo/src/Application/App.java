package Application;

import Advert.Advert;
import Advert.Localization;
import Advert.Province;
import Vehicle.Car;
import Vehicle.CarState;
import Vehicle.Make;
import java.util.HashSet;
import java.util.Set;

public class App {
    private Set<Advert> _adverts;
    
    public App() {
        this._adverts = this.SampleAdverts();
    }
    
    public void AddAdvert(Advert adv) {
        if(adv != null)
            this._adverts.add(adv);
    }
    public Set<Advert> GetAllAdverts() {
        return this._adverts;
    }
    public Set<Advert> GetAdvertByQuery(MyQuery query) {
        Set<Advert> adverts = new HashSet<>();
        
        for(Advert adv : this._adverts)
            if(this.AdvertMatchQuery(adv, query))
                adverts.add(adv);
        
        
        return adverts;
    }
    
    
    private Set<Advert> SampleAdverts() {
        Set<Advert> adverts = new HashSet<>();
        
        Car car = new Car(Make.Kia);
        Localization localization = new Localization(Province.Pomorskie, "Gdynia");
        Advert adv = new Advert(car, 12000.50f, localization, CarState.New);
        
        adverts.add(adv);
        
        car = new Car(Make.Fiat, 1000, 1994);
        localization = new Localization(Province.KujawskoPomorskie, "Bydgoszcz");
        adv = new Advert(car, 1000f, localization, CarState.Used);
        
        adverts.add(adv);
        
        car = new Car(Make.Audi, 9999, 1990);
        localization = new Localization(Province.Zachodniopomorskie, "Szczecin");
        adv = new Advert(car, 300f, localization, CarState.Damaged);
        
        adverts.add(adv);
        return adverts;
    }
    private boolean AdvertMatchQuery(Advert adv, MyQuery query) {
        boolean isMatch = false;
        
        // uszczególnić wyszukiwanie marka(&) + (|)reszta
        if(adv.Car.Make.equals(query.CarMake) && (
                adv.Price <= query.Price ||
                adv.Car.Mileage <= query.Mileage ||
                adv.Car.YearOfProduction <= query.YoP ||
                adv.Localization.equals(query.Localization) ||
                adv.CarState.equals(query.CarState) ||
                adv.Date.toLocaleString().equals(query.AdvertDate.toLocaleString())))
            isMatch = true;
        
        
        return isMatch;
    }
}
