/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s12737
 */
public class Zadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product p1 = new Product("Toster", 100);
        System.out.println(p1.toString());
        
        RepostMaker rM = new RepostMaker();
        rM.visit(p1);
        System.out.println(rM._report);
        
        List<Product> l = new ArrayList<>();
          l.add(p1);
          l.add(new Product("Kosiarka", 101231));
          
        Order o1 = new Order("Order nr 1", l);
        rM.visit(o1);
        System.out.println(rM._report);
    }
}
