import java.util.Arrays;
import java.util.Random;

public class Creature {
    private final Random random = new Random();
    private int attack = random.nextInt(30) + 1;
    private int defence = random.nextInt(30) + 1;
    private int[] damage = {1, 6};
    protected int maxHealth = random.nextInt(50) + 1;
    private int health = maxHealth;

    public Creature() {
    }

    public Creature(int attack, int defence, int[] damage, int maxHealth) {
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int attack(Creature creature) {
        int modifier = Math.max(1, attack - creature.attack + 1);
        Dice dice = new Dice();
        boolean success = false;
        do {
            if (dice.roll() >= 5) {
                success = true;
                System.out.println("Attack is successful");
                break;
            }
            modifier--;
        } while (modifier > 0);
        if (success) {
            int loss = random.nextInt(damage[1] - damage[0]) + damage[0];
            creature.minusHealth(loss);
        }
        return creature.getHealth();
    }

    protected void minusHealth(int loss) {
        health -= loss;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                ", attack=" + attack +
                ", defence=" + defence +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + maxHealth +
                '}';
    }
}
