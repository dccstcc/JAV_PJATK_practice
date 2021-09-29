package zadanie;

public interface Visitable {
    public void accept(Visitor visitor);
    public String giveReport();
}