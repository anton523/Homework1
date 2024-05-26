public abstract class Hero implements Mortal{
    private String name;
    private int health;
    private int damage;

    public Hero(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return "\u001B[32m" + name + "\u001B[0m";
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
    public abstract void attackEnemy(Enemy enemy);
    public abstract void counterAttack(Enemy enemy);
    @Override
    public boolean isAlive(){
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
