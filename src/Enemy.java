import javax.xml.namespace.QName;

public abstract class Enemy implements Mortal{
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name= name;
        this.health = health;
        this.damage = damage;
    }
    public String getName(){
        return "\u001B[31m" + name + "\u001B[0m";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public abstract void takeDamage(int damage);
    public abstract void attackHero(Hero hero);
    public abstract void counterAttack(Hero hero);

    @Override
    public boolean isAlive() {
        return health > 0;
    }
    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public String toString() {
        if (health<=0) return getName() + " мёртв";
        else return getName() + " здоровье = " + health;
    }
}
