public class Skeleton extends Enemy{
    public Skeleton(String name, int health, int damage) {
        super(name, health, damage);
    }
    public Skeleton() {
        super("Скелет", 50, 15);
    }

    @Override
    public void counterAttack(Hero hero){
        int damage = (int) Math.round(getDamage() * (0.7 + Math.random() * 0.6));
        if (Math.random() < 0.2) {
            System.out.print(getName() + " бьёт в ответ " + hero.getName() + "\u001B[35m" + " но промахивается" + "\u001B[0m");
        } else {
            if (Math.random() > 0.3) {
                hero.takeDamage(damage);
                System.out.print(getName() + " бьёт в ответ " + hero.getName() + " и наносит " + damage + " урона");
            } else {
                hero.takeDamage(damage * 2);
                System.out.print(getName() + " бьёт в ответ с удвоенной силой " + hero.getName() + " и наносит " + "\u001B[33m" + damage * 2 + "\u001B[0m" + " урона");
            }
        }
        if (hero.isAlive()) System.out.println(" /// У героя " + hero.getName() + " осталось " + hero.getHealth() + " здоровья");
        else System.out.println(" ///" + " Герой " + hero.getName() + " погибает");
    }
    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth()-damage);
    }

    @Override
    public void attackHero(Hero hero) {
        if (this.isDead()) {
            System.out.println(this.getName() + " мёртв и не может атаковать");
            return;
        }
        if (hero.isDead()) {
            System.out.println(hero.getName() + " уже мёртв");
            return;
        }
        int damage = (int) Math.round(getDamage() * (0.7 + Math.random() * 0.6));
        if (Math.random() < 0.2) {
            System.out.print(getName() + "\u001B[35m" + " промахивается по " + "\u001B[0m" + hero.getName());
        } else {
            if (Math.random() > 0.3) {
                hero.takeDamage(damage);
                System.out.print(getName() + " бьёт " + hero.getName() + " и наносит " + damage + " урона");
            } else {
                hero.takeDamage(damage * 2);
                System.out.print(getName() + " бьёт с удвоенной силой " + hero.getName() + " и наносит " + "\u001B[33m" + damage * 2 + "\u001B[0m" + " урона");
            }
        }
        if (hero.isAlive()) System.out.println(" /// У героя " + hero.getName() + " осталось " + hero.getHealth() + " здоровья");
        else System.out.println(" ///" + " Герой " + hero.getName() + " погибает");
        if (hero.isAlive() && Math.random()<0.33){
            hero.counterAttack(this);
        }
    }
}