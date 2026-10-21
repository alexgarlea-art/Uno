import java.util.Random;

public class Hand extends List<Card> {
    private Random random;

    public Hand() {
        super();
        this.random = new Random();
    }

    // card enters at the tail
    public void addCard(Node<Card> card) {
        this.addTail(card);
    }

    // removes the card at position index and returns it
    public Node<Card> playWithIndex(int index) {
        if (this.getHead() == null) {
            System.out.println("[warning] the hand is empty");
            return null;
        }
        if (index < 0) {
            System.out.println("[warning] invalid index");
            return null;
        }

        Node<Card> cur = this.getHead();
        int count = 0;

        while (cur != null && count < index) {
            cur = cur.getNext();
            count++;
        }

        if (cur == null) {
            System.out.println("[warning] index out of bounds");
            return null;
        }

        if (cur == this.getHead()) {
            this.removeHead();
        } else if (cur == this.getTail()) {
            this.removeTail();
        } else {
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            cur.setNext(null);
            cur.setPrev(null);
        }
        return cur;
    }

    // picks a random card among the playable ones.
    // If onlyTen is true, only 10s are playable (when there is a penalty to draw).
    // Returns null if no card is playable.
    public Node<Card> playRandom(Card top, boolean onlyTen) {
        int playable = 0;
        Node<Card> cur = this.getHead();

        while (cur != null) {
            if (canPlay(cur.getValue(), top, onlyTen)) {
                playable++;
            }
            cur = cur.getNext();
        }

        if (playable == 0) {
            return null;
        }

        int choice = this.random.nextInt(playable);
        int index = 0;
        cur = this.getHead();

        while (cur != null) {
            if (canPlay(cur.getValue(), top, onlyTen)) {
                if (choice == 0) {
                    return this.playWithIndex(index);
                }
                choice--;
            }
            cur = cur.getNext();
            index++;
        }
        return null;
    }

    private boolean canPlay(Card card, Card top, boolean onlyTen) {
        if (onlyTen) {
            return card.getValue() == 10;
        }
        return card.getValue() == top.getValue() || card.getColor() == top.getColor();
    }

    @Override
    public String toString() {
        if (this.getHead() == null) {
            return "[ ]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<Card> cur = this.getHead();

        while (cur != null) {
            sb.append(cur.toString());
            if (cur.getNext() != null) {
                sb.append(", ");
            }
            cur = cur.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
