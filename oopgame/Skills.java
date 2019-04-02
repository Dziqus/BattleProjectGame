package oopgame;

public class Skills
{
  public static int fireball(Warrior warrior)
  {
    warrior.mana -= 15;
    return 200;
  }
}
