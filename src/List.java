public class List<T> {
    private Node<T> head;
    private Node<T> tail;

    //Constructor
    public List(){
    }

    //Methods
    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void addHead(T value){
        if(this.head == null){
            this.head = new Node<T>(value);
            this.tail = this.head;
        }else{
            Node<T> newNode = new Node<T>(value);
            this.head.setPrev(newNode);
            this.head.getPrev().setNext(this.head);
            this.head = newNode;
        }
    }

    public void addTail(T value){
        if(this.tail == null){
            this.tail = new Node<T>(value);
            this.head = this.tail;
        }else{
            Node<T> newNode = new Node<T>(value);
            this.tail.setNext(newNode);
            this.tail.getNext().setPrev(this.tail);
            this.tail = newNode;
        }
    }

    @Override
    public String toString(){
     StringBuilder string = new StringBuilder();

     Node<T> cur = this.head;
     int n = 0;
     while(cur != null){
         System.out.println("Ciao" + (n++));
         string.append(cur.toString()).append("\n");
         cur = cur.getNext();
     }
     return string.toString();
    }
}
