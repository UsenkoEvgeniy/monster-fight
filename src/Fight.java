public class Fight {
    Creature monster;
    Creature player;

    public Fight(Creature monster, Creature player) {
        this.monster = monster;
        this.player = player;
    }

    public boolean fight() {
        System.out.println("Player: " + player.toString());
        System.out.println("Monster: " + monster.toString());
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("Player attacks monster");
            if (player.attack(monster) <= 0) {
                System.out.println("Monster is dead");
                return true;
            }
            System.out.println("Monster health: " + monster.getHealth());
            System.out.println("Monster attacks player");
            if (monster.attack(player) <= 0) {
                System.out.println("Player is dead");
                return false;
            }
            System.out.println("Player health: " + player.getHealth());
        }
        return true;
    }
}
