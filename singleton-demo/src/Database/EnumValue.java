package Database;

public class EnumValue {
    public int Id, EnumId;
    public String Code, Value;
    public EnumerationName EnumerationName;
    
    public EnumValue(int id, int enumId, String code, String value, EnumerationName enumName) {
        this.Id = id;
        this.EnumId = enumId;
        this.Code = code;
        this.Value = value;
        this.EnumerationName = enumName;
    }
}