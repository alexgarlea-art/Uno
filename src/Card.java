import java.awt.*;

public class Card {
    private final int number;
    private final Colors color;

    public Card(int number, Colors color){
        this.number = number;
        this.color = color;
    }

    public Colors getColor(){return this.color;}

    public int getNumber(){return this.number;}

    @Override
    public String toString(){
        return  String.format("Number: %-2s |  Color: %-6s",
                this.number,
                this.color
        );
    }
}

