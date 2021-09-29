package Advert;
public class Localization {
    public Province Province;
    public String City;
    
    public Localization() {}
    public Localization(Province province, String city) {
        this.Province = province;
        this.City = city;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str +=  this.Province + ", " + this.City + "";
        
        return str;
    }
}
