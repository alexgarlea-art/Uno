public class Node<T> {
    private final T value;
    private Node<T> next;
    private Node<T> prev;

    //Constructor
    public Node(T value){
        this.value = value;
    }

    //Methods
    public Node<T> getNext(){return this.next;}

    public Node<T> getPrev(){return this.prev;}

    public void setNext(Node<T> next){this.next = next;}

    public void setPrev(Node<T> prev){this.prev = prev;}

    @Override
    public String toString(){
        return value.toString();
    }
}
