public class Player {
    private Hand hand;
    private String name;

    public Player(String name) {
        this.hand = new Hand();
        this.name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
