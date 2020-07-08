package oopGameTest;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import oopgame.Warrior;

public class BattleTest
{

  @Test
  public static void test() 
  {
    Warrior wizzard = new Warrior("wizzard", 1, 200, 20, 0, "wizzard");
    ArrayList<Integer> damages = new ArrayList<Integer>();
    for (int i = 0; i < 20; i++)
    {
      damages.add(Warrior.attack(wizzard));
    }
  }
}
