import java.util.Random;

public class Main {
    public static Card[] playingCards(){
        Card[] arr = new Card[40];

        for(int i = 0; i < 10; i++){
            arr[i] = new Card(i, Colors.RED);
        }

        for(int i = 0; i < 10; i++){
            arr[i + 10] = new Card(i, Colors.YELLOW);
        }

        for(int i = 0; i < 10; i++){
            arr[i + 20] = new Card(i, Colors.GREEN);
        }

        for(int i = 0; i < 10; i++){
            arr[i + 30] = new Card(i, Colors.BLUE);
        }

        return arr;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card[] arr = playingCards();

        for(Card c : arr){
            deck.push(c);
        }

        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        System.out.println(deck.getNodeAt(2));;
    }
}