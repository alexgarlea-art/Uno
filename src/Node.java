public class Node<T> {
    private T value;
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

    public T getValue(){return this.value;}

    /**
     * swaps two nodes
     * @param node to swap with
     */
    public void swap(Node<T> node){
        if(node == null || this == node) {
            return;
        }

        T temp = this.value;
        this.value = node.value;
        node.value = temp;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
