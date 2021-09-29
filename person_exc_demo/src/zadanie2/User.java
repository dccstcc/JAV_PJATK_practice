/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie2;

import java.util.List;

/**
 *
 * @author s12737
 */
public class User {
    public String Login, Password, FirstName, LastName;
    public List<Address> Addresses;
    public List<String> PhoneNumbers;
    public List<Role> Roles;
    
    
    public User(String login, String pass, String fN, String lN,
            List<Address> addr, List<String> phoneNumbers, List<Role> roles)
    {
        this.Login = login;
        this.Password = pass;
        this.FirstName = fN;
        this.LastName = lN;
        this.Addresses = addr;
        this.PhoneNumbers = phoneNumbers;
        this.Roles = roles;
    }
}
