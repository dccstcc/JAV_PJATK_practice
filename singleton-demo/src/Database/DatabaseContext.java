
package Database;

import java.util.HashMap;
import java.util.Map;
public class DatabaseContext {
    public static Map<EnumerationName, EnumValue> getData() {
        Map<EnumerationName, EnumValue> items = new HashMap<>();
        items.put(EnumerationName.Gender, 
                new EnumValue(1, 2,"M", "Paweł", EnumerationName.Gender));
          items.put(EnumerationName.Gender, 
                new EnumValue(2, 2,"K", "Karolina", EnumerationName.Gender));
          
            items.put(EnumerationName.Regions, 
                new EnumValue(3, 1,"Byd", "Bydgoszcz", EnumerationName.Regions));
        return items;
    }
}
