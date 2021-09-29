package zad1.faktura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Zad1Faktura {

    public static void main(String[] args) {
        List<Invoice> invoices = invoiceInitialization();
        
        for(Invoice inv : invoices) {
            invoiceDetails(inv);
             System.out.println("\n");
        }
        for(Invoice inv : invoices) {
            invoiceArticlesDetails(inv);
            System.out.println("\n");
        }
        
        Scanner user_input = new Scanner(System.in);
        System.out.print("Enter article to search in invoices: ");
        searchForArticleInInvoices(invoices, user_input.nextLine());
    }
    private static List<Invoice> invoiceInitialization()
    {
        List<Invoice> invoices = new ArrayList<Invoice>();
        
        List<Line> lines1 = new ArrayList<>();
        lines1.add(new Line(1, 
                new Article("Toster", Unit.Piece, new Price(173, 0.2f)),
                2));
        lines1.add(new Line(2, 
                new Article("Woda", Unit.Liter, new Price(3.50f, 0.7f)),
                30));
        lines1.add(new Line(3, 
                new Article("Ziemia", Unit.Ton, new Price(50, 0)),
                7));
        
        invoices.add(new Invoice("Invoice No. 1", lines1, new Date(), 
                    new PaymentDate(10, new Date())));
        
        List<Line> lines2 = new ArrayList<>();
        lines2.add(new Line(1, 
                new Article("Pierogi", Unit.Piece, new Price(5.50f, 0.2f)),
                100));
        lines2.add(new Line(2, 
                new Article("Rower", Unit.Piece, new Price(333.50f, 0.30f)),
                4));
        lines2.add(new Line(3, 
                new Article("Ziemia", Unit.Ton, new Price(50, 0.17f)),
                122));
        lines2.add(new Line(4, 
                new Article("BMW", Unit.Piece, new Price(1292, 0.23f)),
                1 ));
        
        invoices.add(new Invoice("Invoice No. 2", lines2, new Date(), 
                    new PaymentDate(17, new Date())));
        
        return invoices;
    }
    private static void invoiceDetails(Invoice inv)
    {
        if(inv != null)
            System.out.println(inv.toString());
    }
    private static void invoiceArticlesDetails(Invoice inv)
    {
        if(inv != null)
            for(Line line : inv.Lines)
                System.out.println(line.Article.toString());
    }
    private static void searchForArticleInInvoices(List<Invoice> invoices, String article)
    {
        String msg = "";
        for(Invoice inv : invoices)
            for(Line line : inv.Lines)
                if(line.Article.Name.equalsIgnoreCase(article))
                {
                    msg += "Found in " + inv.Number + " in line No. " + line.Number
                            + " and here are the details of the product:\n " + line.Article.toString() + ".";
                    System.out.println(msg);
                    msg = "";
                }
    }
}
