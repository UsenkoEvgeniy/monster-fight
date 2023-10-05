import java.util.Random;

public class Dice {
    private static final Random RANDOM = new Random();

    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }
}
