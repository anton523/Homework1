public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage);
    }
    public Warrior() {
        super("Воин", 100, 12);
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
        int damage = (int) Math.round(getDamage() * (0.7 + Math.random() * 0.6));
        if (enemy instanceof Ogre) {
            if (Math.random() > 0.2) {
                enemy.takeDamage(damage);
                System.out.print(getName() + " попадает мечом по " + enemy.getName() + " и наносит " + damage + " урона");
            } else {
                enemy.takeDamage(damage * 3);
                System.out.print(getName() + " попадает сильным ударом меча по " + enemy.getName() + " и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
            }
            if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
            else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
        }
        if (enemy instanceof Skeleton) {
            if (Math.random() < 0.3){
                System.out.print(getName() + "\u001B[35m" + " промахивается по "  + "\u001B[0m" + enemy.getName());
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает мечом по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 3);
                    System.out.print(getName() + " попадает сильным ударом меча по " + enemy.getName() + " и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
                }
            }
            if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
            else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
            if (enemy.isAlive() && Math.random()<0.33){
                enemy.counterAttack(this);
            }

        }
        if (enemy instanceof Zombie) {
            if (Math.random() < 0.1){
                System.out.print(getName() + "\u001B[35m" + " промахивается по "  + "\u001B[0m" + enemy.getName());
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает мечом по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 3);
                    System.out.print(getName() + " попадает сильным ударом меча по " + enemy.getName() + " и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
                }
            }
            if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
            else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
            if (enemy.isAlive() && Math.random()<0.66){
                enemy.counterAttack(this);
            }
        }
    }
    @Override
    public void counterAttack(Enemy enemy) {
        int damage = (int) Math.round(getDamage() * (0.7 + Math.random() * 0.6));
        if (enemy instanceof Ogre) {
            if (Math.random() > 0.2) {
                enemy.takeDamage(damage);
                System.out.print(getName() + " попадает мечом в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
            } else {
                enemy.takeDamage(damage * 3);
                System.out.print(getName() + " попадает мечом в ответ по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
            }
        }
        if (enemy instanceof Skeleton) {
            if (Math.random() < 0.3){
                System.out.print(getName() + " ударяет мечом в ответ по " + enemy.getName() + "\u001B[35m" + " но промахивается" + "\u001B[0m");
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает мечом в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 3);
                    System.out.print(getName() + " попадает мечом по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
                }
            }

        }
        if (enemy instanceof Zombie) {
            if (Math.random() < 0.1){
                System.out.print(getName() + " ударяет мечом в ответ по " + enemy.getName() + "\u001B[35m" + " но промахивается" + "\u001B[0m");
            } else {
                if (Math.random() > 0.2) {
                    enemy.takeDamage(damage);
                    System.out.print(getName() + " попадает мечом в ответ по " + enemy.getName() + " и наносит " + damage + " урона");
                } else {
                    enemy.takeDamage(damage * 3);
                    System.out.print(getName() + " попадает мечом в ответ по " + enemy.getName() + " c невероятной силой и наносит " + "\u001B[33m"+ damage * 3 + "\u001B[0m" + " урона");
                }
            }
        }
        if (enemy.isAlive()) System.out.println(" /// У врага " + enemy.getName() + " осталось " + enemy.getHealth() + " здоровья");
        else System.out.println(" ///" + " Враг " + enemy.getName() + " погибает");
    }
}