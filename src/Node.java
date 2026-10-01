public class Node {
    private final int number;
    private final Colors color;
    private Card next;
    private Card prev;

    //Constructor
    public Node(int number, Colors color){
        this.number = number;
        this.color = color;
    }

    //Methods
    public Colors getColor(){return this.color;}

    public int getNumber(){return this.number;}

    public Card getNext(){return this.next;}

    public Card getPrev(){return this.prev;}

    public void setNext(Card next){this.next = next;}

    public void setPrev(Card prev){this.prev = prev;}

    @Override
    public String toString(){
        if(this.prev != null && this.next != null){
            return String.format("Prev: %-10s Number: %-10s Color: %-10s Next: %-10s",
                    this.prev,
                    this.number,
                    this.color,
                    this.next
            );
        }else if(this.prev == null) {
            if (this.next != null) {
                return String.format("Prev: %-10s Number: %-10s Color: %-10s Next: %-10s",
                        null,
                        this.number,
                        this.color,
                        null
                );
            } else {
                return String.format("Prev: %-10s Number: %-10s Color: %-10s Next: %-10s",
                        null,
                        this.number,
                        this.color,
                        null
                );
            }
        }else{
            return String.format("Prev: %-10s Number: %-10s Color: %-10s Next: %-10s",
                    this.prev,
                    this.number,
                    this.color,
                    null
            );
        }
    }
}
