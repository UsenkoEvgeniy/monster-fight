import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player;
        System.out.println("You can create player or generate. Enter 'c' to create or press any key to generate");
        if (scanner.nextLine().equalsIgnoreCase("c")) {
            System.out.println("Player has four stats: health, attack, defence and damage");
            System.out.println("Please, enter health, integer number between 1 and 100: ");
            int health = getInt(1, 100);
            System.out.println("Enter attack, integer number between 1 and 30");
            int attack = getInt(1, 30);
            System.out.println("Enter defence, integer number between 1 and 30");
            int defence = getInt(1, 30);
            System.out.println("Enter damage lower bound, integer number between 1 and 29");
            int low = getInt(1, 29);
            System.out.println("Enter damage upper bound, integer number between " + (low + 1) + " and 30");
            int up = getInt(low + 1, 30);
            int[] damage = {low, up};
            player = new Player(attack, defence, damage, health);
        } else {
            player = new Player();
        }
        System.out.println("How many monster player will fight? ");
        int numOfMonsters = getInt(1, 10);
        List <Monster> monsters = new ArrayList<>();
        for (int i = 0; i < numOfMonsters; i++) {
            monsters.add(new Monster());
        }

        for (Monster monster: monsters) {
            Fight fight = new Fight(monster, player);
            if (fight.fight()) {
                System.out.println("Player wins.");
            } else {
                System.out.println("Monsters win");
                return;
            }
        }
        System.out.println("Congratulation!");
    }

    public static int getInt(int lowerBound, int upperBound) {
        int ret;
        while (true) {
            String line = scanner.nextLine();
            try {
                ret = Integer.parseInt(line);
                if (ret < lowerBound || ret > upperBound) {
                    System.out.println("You must enter integer number between " + lowerBound + " and " + upperBound);
                    continue;
                }
                return ret;
            } catch (NumberFormatException e) {
                System.out.println("You must enter integer number between " + lowerBound + " and " + upperBound);
            }
        }
    }
}