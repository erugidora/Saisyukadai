import java.util.ArrayList;

public class GameMaster {
    public static void main(String[] args) {
        // 味方パーティの編成
        ArrayList<Character> party = new ArrayList<Character>();
        Hero hero = new Hero("勇者", 100, "剣");
        Wizard wizard = new Wizard("魔法使い", 60, 20);
        Thief thief = new Thief("盗賊", 70);
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        // 敵グループの編成
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        Matango matango = new Matango('A', 45);
        Goblin goblin = new Goblin('A', 50);
        Slime slime = new Slime('A', 40);
        monsters.add(matango);
        monsters.add(goblin);
        monsters.add(slime);

        // ステータス表示（戦闘前）
        System.out.println("=== 味方パーティ ===");
        for (Character member : party) {
            member.showStatus();
        }

        System.out.println("=== 敵パーティ ===");
        for (Monster member : monsters){
            member.showStatus();
        }

        // 味方の総攻撃
        System.out.println("\n=== 味方の総攻撃！ ===");
        for (Character member : party) {
            for (Monster m : monsters) {
                    member.attack(m);
            }
        }

        // 敵の総攻撃
        System.out.println("\n=== 敵の総攻撃！ ===");
        for (Monster member : monsters) {
            for (Character m : party) {
                    member.attack(m);
            }
        }

        // クラスチェンジイベント
        SuperHero superHero = new SuperHero(hero);
        party.set(0, superHero);
        System.out.println("\nダメージを受けた勇者が突然光りだした！");
        System.out.println("勇者はスーパーヒーローに進化した！");
        for(Character member : party){
            if(member.equals(superHero)){
                for(Monster m : monsters){
                    member.attack(m);
                }
            }
        }

        // 最終ステータス
        System.out.println("\n=== 味方パーティ最終ステータス ===");
        for (Character member : party) {
            member.showStatus();
            if (member.isAlive() == false) {
                System.out.println("生存状況:戦闘不能");
            } else {
                System.out.println("生存状況:生存");
            }
        }

        System.out.println("\n=== 最終ステータス：モンスター ===");
        for (Monster member : monsters) {
            member.showStatus();
            if(member.isAlive() == false){
                System.out.println("生存状況:討伐済み");
            }else{
                System.out.println("生存状況:生存");
            }
        }
    }
}