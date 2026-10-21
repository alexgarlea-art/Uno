public class Game {
    private static final int INITIAL_CARDS = 3;
    private static final int MAX_TURNS = 10000;
    private static final String DOUBLE_LINE = "=".repeat(64);
    private static final String SINGLE_LINE = "-".repeat(64);

    private Deck deck;
    private Plate plate;
    private PlayerList players;
    private Node<Player> current;
    private boolean clockwise;
    private int penalty;
    private Player winner;

    public Game(String[] names) {
        this.deck = new Deck();
        this.plate = new Plate();
        this.players = new PlayerList();
        this.clockwise = true;
        this.penalty = 0;
        this.winner = null;

        this.deck.createFullDeck();
        this.deck.shuffle();

        for (int i = 0; i < names.length; i++) {
            this.players.addPlayer(new Node<Player>(new Player(names[i])));
        }
        this.current = this.players.getHead();

        // every player draws the initial cards
        for (int i = 0; i < INITIAL_CARDS; i++) {
            Node<Player> cur = this.players.getHead();
            do {
                cur.getValue().getHand().addCard(this.deck.pop());
                cur = cur.getNext();
            } while (cur != this.players.getHead());
        }

        // starting card: if it is special (10, 11, 12) put it back in the deck and draw another
        Node<Card> first = this.deck.pop();
        while (first.getValue().getValue() > 9) {
            this.deck.push(first);
            this.deck.shuffle();
            first = this.deck.pop();
        }
        this.plate.push(first);
    }

    public void start() {
        System.out.println(DOUBLE_LINE);
        System.out.println(center("CARD GAME"));
        System.out.println(DOUBLE_LINE);
        System.out.printf("Players       : %s%n", this.players);
        System.out.printf("Starting card : %s%n", this.plate.top());
        System.out.println();

        int turns = 0;
        while (this.winner == null && turns < MAX_TURNS) {
            turns++;
            this.playTurn(turns);
        }

        System.out.println(DOUBLE_LINE);
        if (this.winner != null) {
            System.out.println(center(this.winner.getName() + " wins after " + turns + " turns!"));
        } else {
            System.out.println(center("Game stopped: too many turns without a winner"));
        }
        System.out.println(DOUBLE_LINE);
    }

    private String center(String text) {
        int padding = (DOUBLE_LINE.length() - text.length()) / 2;
        if (padding < 0) {
            padding = 0;
        }
        return " ".repeat(padding) + text;
    }

    private Node<Player> next(Node<Player> node) {
        if (this.clockwise) {
            return node.getNext();
        }
        return node.getPrev();
    }

    // draws one card; if the deck is empty the plate is reshuffled (except the top card)
    private boolean draw(Player player) {
        if (this.deck.size() == 0) {
            this.refillDeck();
        }
        if (this.deck.size() == 0) {
            return false;
        }
        player.getHand().addCard(this.deck.pop());
        return true;
    }

    private void refillDeck() {
        if (this.plate.size() <= 1) {
            return;
        }
        Node<Card> last = this.plate.pop();
        while (this.plate.size() > 0) {
            this.deck.push(this.plate.pop());
        }
        this.deck.shuffle();
        this.plate.push(last);
        System.out.println("  [deck empty: plate reshuffled into the deck]");
    }

    private void playTurn(int turn) {
        Player player = this.current.getValue();
        Card top = this.plate.top();
        Node<Card> played;

        System.out.println(SINGLE_LINE);
        System.out.printf("Turn %d - %s (%s)%n", turn, player.getName(),
                this.clockwise ? "clockwise" : "counter-clockwise");
        System.out.printf("  Plate : %s%n", top);
        System.out.printf("  Hand  : %s%n", player.getHand());
        if (this.penalty > 0) {
            System.out.printf("  Penalty pending: +%d cards (only a 10 can answer)%n", this.penalty);
        }

        if (this.penalty > 0) {
            // there is a penalty: the player can only answer with another 10
            played = player.getHand().playRandom(top, true);

            if (played == null) {
                System.out.printf("  >> %s has no 10 and draws %d cards%n", player.getName(), this.penalty);
                for (int i = 0; i < this.penalty; i++) {
                    this.draw(player);
                }
                this.penalty = 0;
                this.current = this.next(this.current);
                return;
            }
        } else {
            played = player.getHand().playRandom(top, false);

            if (played == null) {
                System.out.printf("  >> %s cannot play and draws one card%n", player.getName());
                this.draw(player);
                this.current = this.next(this.current);
                return;
            }
        }

        Card card = played.getValue();
        this.plate.push(played);
        System.out.printf("  >> %s plays %s  (%d cards left)%n",
                player.getName(), card, player.getHand().size());

        if (player.getHand().size() == 0) {
            this.winner = player;
            return;
        }

        if (card.getValue() == 10) {
            this.penalty += 2;
            System.out.printf("  !! Penalty stacked: next player draws %d cards%n", this.penalty);
        } else if (card.getValue() == 11) {
            this.clockwise = !this.clockwise;
            System.out.println("  !! Direction reversed");
        } else if (card.getValue() == 12) {
            this.current = this.next(this.current);
            System.out.printf("  !! %s skips a turn%n", this.current.getValue().getName());
        }

        this.current = this.next(this.current);
    }
}
