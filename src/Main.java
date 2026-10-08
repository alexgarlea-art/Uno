//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Card> test = new List<Card>();
        test.addTail(new Card(9, Colors.RED));
        test.addTail(new Card(6, Colors.RED));
        test.addTail(new Card(7, Colors.BLUE));
        System.out.println(test.toString());
    }
}