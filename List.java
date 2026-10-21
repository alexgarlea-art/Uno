public class List<T> {
    private Node<T> head;
    private Node<T> tail;

    protected List() {
        this.head = null;
        this.tail = null;
    }

    protected Node<T> getHead() {
        return this.head;
    }

    protected Node<T> getTail() {
        return this.tail;
    }

    protected void setHead(Node<T> head) {
        this.head = head;
    }

    protected void setTail(Node<T> tail) {
        this.tail = tail;
    }

    protected void insert(int index, Node<T> node) {
        if (index <= 0) {
            addHead(node);
        } else {
            int count = 0;
            Node<T> cur = head;
            while (cur != null && count < index) {
                count++;
                cur = cur.getNext();
            }
            if (cur == null) {
                addTail(node);
            } else {
                node.setNext(cur);
                node.setPrev(cur.getPrev());
                cur.getPrev().setNext(node);
                cur.setPrev(node);
            }
        }
    }

    protected void addHead(Node<T> node) {
        node.setPrev(null);
        node.setNext(head);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }

        head.setPrev(node);
        head = node;
    }

    protected void addTail(Node<T> node) {
        node.setNext(null);

        if (this.head == null) {
            node.setPrev(null);
            this.head = node;
            this.tail = node;
            return;
        }

        node.setPrev(this.tail);
        this.tail.setNext(node);
        this.tail = node;
    }

    protected Node<T> removeHead() {
        if (this.head == null) {
            System.out.println("[warning] the list is empty");
            return null;
        }
        Node<T> removed = this.head;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        removed.setNext(null);
        removed.setPrev(null);
        return removed;
    }

    protected Node<T> removeTail() {
        if (this.tail == null) {
            System.out.println("[warning] the list is empty");
            return null;
        }
        Node<T> removed = this.tail;

        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        removed.setNext(null);
        removed.setPrev(null);
        return removed;
    }

    public int size() {
        int count = 0;
        Node<T> cur = head;

        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[ empty list ]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("List (size: ").append(size()).append(")").append(System.lineSeparator());

        int i = 0;
        Node<T> cur = head;
        while (cur != null) {
            sb.append(String.format("  %d: %s", i, cur.getValue()));
            if (cur == head) sb.append("  <- head");
            if (cur == tail) sb.append("  <- tail");
            sb.append(System.lineSeparator());
            cur = cur.getNext();
            i++;
        }
        return sb.toString();
    }
}
