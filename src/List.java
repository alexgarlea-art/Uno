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

    public void setHead(Node<T> node){
        this.head = node;
    }

    public void setTail(Node<T> node){
        this.tail = node;
    }

    public int size(){
        int count = 0;
        Node<T> cur = this.head;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public Node<T> getNodeAt(int index){
        if (index < 0 || index >= this.size()) {
            System.out.println("index " + index + " out of bounds");
            return null;
        }

        Node<T> cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }


    @Override
    public String toString(){
     StringBuilder string = new StringBuilder();

     Node<T> cur = this.head;
     int n = 0;
     while(cur != null){
         string.append(cur.toString()).append("\n");
         cur = cur.getNext();
     }
     return string.toString();
    }
}
