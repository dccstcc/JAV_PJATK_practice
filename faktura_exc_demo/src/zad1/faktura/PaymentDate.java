package zad1.faktura;

import java.util.Date;

public class PaymentDate {
    private int _daysLeft;
    private Date _date;
    
    public PaymentDate(int days) {
        
    }
    public PaymentDate(Date date) {
        
    }
    public PaymentDate(int days, Date date)
    {
        this._daysLeft = days;
        this._date = date;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        str += "{Date: " + this._date.toLocaleString() + ", days left: " + this._daysLeft + "}";
        
        return str;
    }
}
