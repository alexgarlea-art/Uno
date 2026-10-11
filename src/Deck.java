import java.util.Random;

public class Deck extends List<Card>{

    public Deck(){
        super();
    }

    //Methods

    /**
     * Pushes to Deck, adds a Card to head position
     * @param c the card to add
     */
    public void push(Card c){
        this.addHead(c);
    }

    /**
     * pops the Deck, returns and removes the head card
     * @return the deck's Head
     */
    public Card pop(){

        if(this.getHead() == this.getTail()) {
            Card temp = this.getHead().getValue();
            this.setHead(null);
            this.setTail(null);
            return temp;
        }

        Card temp = this.getHead().getValue();

        this.setHead(this.getHead().getNext());
        this.getHead().getPrev().setNext(null);
        this.getHead().setPrev(null);

        return temp;
    }

    public void shuffle(){
        Random rand = new Random();
        for(int i = 0; i < this.size(); i++){
            int nodeIndex = rand.nextInt(this.size());
            this.getNodeAt(i).swap(this.getNodeAt(nodeIndex));
        }
    }
}
