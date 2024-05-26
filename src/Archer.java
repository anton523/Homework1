public class Archer extends Hero {
    public Archer(String name, int health, int damage) {
        super(name, health, damage);
    }
    public Archer() {
        super("Лучник", 20, 10);
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth()-damage);
    }

    public void attackEnemy(Enemy enemy){
        if (this.isDead()) {
            System.out.println(this.getName() + " мёртв и не может атаковать");
            return;
        }
        if (enemy.isDead()) {
            System.out.println("Враг " + enemy.getName() + " уже повержен");
            return;
        }
        int damage = (int) Math.round(getDamage() * (0.8 + Math.random() * 0.4));
        if (enemy instanceof Ogre) {
            if (Math.random() > 0.2) {
                enemy.takeDamage(damage);
                System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой и наносит " + damage + " урона");
            } else {
                enemy.takeDamage(damage * 2);
                System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
            }
        }
        if (enemy instanceof Skeleton) {
            if (Math.random() < 0.3){
                System.out.print(getName() + "\u001B[35m" + " промахивается по " + "\u001B[0m" + enemy.getName());
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 2);
                    System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
                }
            }

        }
        if (enemy instanceof Zombie) {
            if (Math.random() < 0.1){
                System.out.print(getName() + "\u001B[35m" + " промахивается по " + "\u001B[0m" + enemy.getName());
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 2);
                    System.out.print(getName() + " попадает по " + enemy.getName() + " стрелой c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
                }
            }
        }
        if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
        else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
    }

    @Override
    public void counterAttack(Enemy enemy) {
        int damage = (int) Math.round(getDamage() * (0.8 + Math.random() * 0.4));
        if (enemy instanceof Ogre) {
            if (Math.random() > 0.2) {
                enemy.takeDamage(damage);
                System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
            } else {
                enemy.takeDamage(damage * 2);
                System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
            }
        }
        if (enemy instanceof Skeleton) {
            if (Math.random() < 0.3){
                System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + "\u001B[35m" + " но промахивается" + "\u001B[0m");
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 2);
                    System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
                }
            }

        }
        if (enemy instanceof Zombie) {
            if (Math.random() < 0.1){
                System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + "\u001B[35m" + " но промахивается" + "\u001B[0m");
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 2);
                    System.out.print(getName() + " стреляет в ответ по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 2 + "\u001B[0m" + " урона");
                }
            }
        }
        if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
        else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
    }
}
