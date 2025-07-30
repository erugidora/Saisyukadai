public class Hero extends Character {
    private String getWeapon;

    public Hero(String name, int hp, String weapon) {
        super(name, hp);
        this.getWeapon = weapon;
    }

    public void attack(Creature target) {
        System.out.println(this.getName() + "は" + getWeapon + "で攻撃！" + target.getName() + "に10のダメージを与えた！");
        target.setHp(target.getHp() - 10);
    }

    public String getWeapon() {
        return getWeapon;
    }
}
