public interface Creature {
   boolean isAlive();
   void showStatus();
   void attack(Creature target);
   String getName();
   int getHp();
   int setHp(int hp);
}
