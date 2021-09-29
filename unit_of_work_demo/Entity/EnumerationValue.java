package Entity;

public class EnumerationValue extends Entity {
    private int intKey;
    private String stringKey;
    private Object value, enumerationName;

    public EnumerationValue(int intKey, String stringKey,
                            Object value, Object enumerationName) {
        this.intKey = intKey;
        this.stringKey = stringKey;
        this.value = value;
        this.enumerationName = enumerationName;
    }

    public int getIntKey() {
        return this.intKey;
    }
    public void setIntKey(int key) {
        this.intKey = key;
    }
    public String getStringKey() {
        return  this.stringKey;
    }
    public void setStringKey(String key) {
        this.stringKey = key;
    }
    public Object getValue() {
        return this.value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Object getEnumerationName() {
        return  this.enumerationName;
    }
    public void setEnumerationName(Object enumerationName) {
        this.enumerationName = enumerationName;
    }
}
