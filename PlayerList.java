public class PlayerList extends List<Player> {
    private int count;

    public PlayerList() {
        super();
        this.count = 0;
    }

    public void addPlayer(Node<Player> player) {
        this.addTail(player);
        this.getTail().setNext(this.getHead());
        this.getHead().setPrev(this.getTail());
        this.count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        if (this.getHead() == null) {
            return "[ no players ]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<Player> cur = this.getHead();

        do {
            sb.append(cur.toString());
            cur = cur.getNext();
            if (cur != this.getHead()) {
                sb.append(", ");
            }
        } while (cur != this.getHead());

        sb.append("]");
        return sb.toString();
    }
}
