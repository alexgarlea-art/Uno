import java.util.Random;

public class Deck extends List<Card> {
    public Deck() {
        super();
    }

    // for each color: a single 0 and two cards for every other value (1..12)
    public void createFullDeck() {
        for (Color color : Color.values()) {
            this.push(new Node<Card>(new Card(0, color)));
            for (int value = 1; value <= 12; value++) {
                this.push(new Node<Card>(new Card(value, color)));
                this.push(new Node<Card>(new Card(value, color)));
            }
        }
    }

    public void push(Node<Card> node) {
        this.addTail(node);
    }

    public Node<Card> pop() {
        return this.removeTail();
    }

    public void shuffle() {
        int n = this.size();
        if (n <= 1) {
            return;
        }

        Card[] cards = new Card[n];
        Node<Card> cur = this.getHead();
        int index = 0;

        while (cur != null) {
            cards[index] = cur.getValue();
            cur = cur.getNext();
            index++;
        }

        // Fisher-Yates shuffle
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

        cur = this.getHead();
        index = 0;
        while (cur != null) {
            cur.setValue(cards[index]);
            cur = cur.getNext();
            index++;
        }
    }
}
