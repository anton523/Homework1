import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleGround {
    public static void main(String[] args) throws InterruptedException {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Archer());
        heroes.add(new Archer());
        heroes.add(new Warrior("Воин Алёша Попович", 200, 25));
        heroes.add(new Warrior("Воин Добрыня Никитич", 200, 25));
        heroes.add(new Warrior("Воин Илья Муромец", 200, 25));
        heroes.add(new Mage());
        heroes.add(new Mage());

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Ogre());
        enemies.add(new Ogre());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Skeleton());
        enemies.add(new Zombie());
        enemies.add(new Zombie());
        enemies.add(new Zombie());
        enemies.add(new Zombie());
        enemies.add(new Zombie());

        int i=1;
        while (heroesAlive(heroes) && enemiesAlive(enemies)){
            System.out.println("Раунд " + i + ": ");
            getRandomAliveHero(heroes).attackEnemy(getRandomAliveEnemy(enemies));
            Thread.sleep(100);
            if (heroesAlive(heroes) && enemiesAlive(enemies)){
                getRandomAliveEnemy(enemies).attackHero(getRandomAliveHero(heroes));
                Thread.sleep(100);
            }
            i++;
        }
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
        if (heroesAlive(heroes)) System.out.println("Герои победили!");
        else System.out.println("Герои проиграли");


    }
    private static boolean heroesAlive(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                return true;
            }
        }
        return false;
    }
    private static boolean enemiesAlive(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                return true;
            }
        }
        return false;
    }
    private static Hero getRandomAliveHero(List<Hero> heroes) {
        Hero hero = null;
        while (hero == null || hero.isDead()) {
            hero = heroes.get(new Random().nextInt(heroes.size()));
        }
        return hero;
    }
    private static Enemy getRandomAliveEnemy(List<Enemy> enemies) {
        Enemy enemy = null;
        while (enemy == null || enemy.isDead()) {
            enemy = enemies.get(new Random().nextInt(enemies.size()));
        }
        return enemy;
    }
}
