public class Ogre extends Enemy{
    public Ogre(String name, int health, int damage) {
        super(name, health, damage);
    }
    public Ogre() {
        super("Огр", 300, 20);
    }

    @Override
    public void counterAttack(Hero hero){
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
        int damage = (int) Math.round(getDamage() * (0.8 + Math.random() * 0.4));
        if (Math.random() < 0.2) {
            System.out.print(getName() + "\u001B[35m" + " промахивается по " + "\u001B[0m" + hero.getName());
        } else {
            hero.takeDamage(damage);
            System.out.print(getName() + " ударяет " + hero.getName() + " и наносит " + damage + " урона");
        }
        if (hero.isAlive()) System.out.println(" /// У героя " + hero.getName() + " осталось " + hero.getHealth() + " здоровья");
        else System.out.println(" ///" + " Герой " + hero.getName() + " погибает");
        if (hero.isAlive() && Math.random()<0.33){
            hero.counterAttack(this);
        }
    }
}
