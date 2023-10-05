public class Player extends Creature {
    int reviveAttempts = 4;

    public Player() {
    }

    public Player(int attack, int defence, int[] damage, int maxHealth) {
        super(attack, defence, damage, maxHealth);
    }

    @Override
    protected void minusHealth(int loss) {
        int newHealth = getHealth() - loss;
        if (newHealth > 0 || reviveAttempts < 1) {
            setHealth(newHealth);
        } else {
            reviveAttempts--;
            System.out.println("Player is reviving");
            setHealth(Math.max(1, (int) (maxHealth * 0.3)));
        }
    }
}
