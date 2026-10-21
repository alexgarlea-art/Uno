public class Plate extends List<Card> {
    public Plate() {
        super();
    }

    public void push(Node<Card> node) {
        this.addTail(node);
    }

    public Node<Card> pop() {
        return this.removeTail();
    }

    public Card top() {
        if (this.getTail() == null) {
            return null;
        }
        return this.getTail().getValue();
    }
}
