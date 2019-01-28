package OOPGame;

import java.util.Random;
import java.util.Scanner;

public class BattleGame
{
  public static void main(String args[]) throws InterruptedException
  {
    @SuppressWarnings("resource")
    Scanner user_input = new Scanner(System.in);

    System.out.print("Name the first warrior:");
    String input1 = user_input.next();
    Warrior warrior1 = new Warrior(input1, 1000, 120, 50);

    System.out.print("Name the second warrior:");
    String input2 = user_input.next();
    Warrior warrior2 = new Warrior(input2, 1000, 120, 50);

    Battle.startFight(warrior1, warrior2);
  }
}

class Warrior
{

  public String name;
  public int health;
  public static int attkMax;
  public static int blckMax;

  public Warrior(String Name, int Health, int AttkMax, int BlckMax)
  {
    name = Name;
    health = Health;
    attkMax = AttkMax;
    blckMax = BlckMax;
  }

  public static int Attack()
  {
    return new Random().nextInt(attkMax - 0 + 1) + 0;
  }

  public static int Block()
  {
    return new Random().nextInt(blckMax - 0 + 1) + 0;
  }
}

class Battle
{
  public static void startFight(Warrior warriorA, Warrior warriorB) throws InterruptedException
  {
    do
    {
      getAttackResult(warriorB, warriorA, damageRandomizer());
      getAttackResult(warriorA, warriorB, damageRandomizer());
    } while (warriorA.health > 0 && warriorB.health > 0);
    checkIfWin(warriorA, warriorB);
  }

  private static void getAttackResult(Warrior warriorA, Warrior warriorB, int damage)
          throws InterruptedException
  {
    if (damage <= 0)
    {
      System.out.println("\nWarrior " + warriorA.name + " blocked the attack!");
      Thread.sleep(100);
    }
    else
    {
      System.out.println("\nWarrior " + warriorB.name + " did " + damage + " to " + warriorA.name);
      warriorA.health -= damage;
      System.out.println("Warrior " + warriorA.name + " has " + warriorA.health + " Health.");
      Thread.sleep(100);
    }
  }

  private static int damageRandomizer()
  {
    int war1AtkAmt = Warrior.Attack();
    int war2BlkAmt = Warrior.Block();
    int damage = war1AtkAmt - war2BlkAmt;
    return damage;
  }

  private static String checkIfWin(Warrior warrior1, Warrior warrior2)
  {
    if (warrior1.health <= 0)
    {
      return ("Warrior " + warrior2.name + " has died and " + warrior1.name + " is Victorious!");
    }
    else if (warrior2.health <= 0)
    {
      return ("Warrior " + warrior1.name + " has died and " + warrior2.name + " is Victorious!");
    }
    else
    {
      return ("test");
    }
  }
}