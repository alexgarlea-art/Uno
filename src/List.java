public class List {
    private Card head;
    private Card tail;

    //Constructor
    public List(){
    }

    //Methods
    public Card getHead(){
        return this.head;
    }

    public Card getTail(){
        return this.tail;
    }

    public void addHead(int number, Colors color){
        if(this.head == null){
            this.head = new Card(number, color);
            this.tail = this.head;
        }else{
            Card newCard = new Card(number, color);
            this.head.setPrev(newCard);
            this.head.getPrev().setNext(this.head);
            this.head = newCard;
        }
    }

    public void addTail(int number, Colors color){
        if(this.tail == null){
            this.tail = new Card(number, color);
            this.head = this.tail;
        }else{
            Card newCard = new Card(number, color);
            this.tail.setNext(newCard);
            this.tail.getNext().setPrev(this.tail);
            this.tail = newCard;
        }
    }

    @Override
    public String toString(){
     StringBuilder string = new StringBuilder();
     string.append("Head: " + this.head + "\n" + "Tail: " + this.tail + "\n\n");

     Card cur = this.head;
     while(cur != null){
         string.append(cur);
         cur = cur.getNext();
     }
     return string.toString();
    }
}
