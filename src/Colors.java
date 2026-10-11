import java.util.Random;

public enum Colors {
    RED,
    YELLOW,
    GREEN,
    BLUE;

    public static Colors getRandomColor(){
        Random rand = new Random();

        switch (rand.nextInt(4)){
            case 0 ->{
                return RED;
            }
            case 1 ->{
                return YELLOW;
            }
            case 2 -> {
                return GREEN;
            }
            case 3 ->{
                return BLUE;
            }
        }
        System.out.println("Non-valid random index. Returning null.");
        return null;
    }
}
