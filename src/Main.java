//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Card test = new Card(4, Colors.YELLOW);
        test.setNext(new Card(7, Colors.RED));
        System.out.println(test.getNext());
    }
}