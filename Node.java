public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
