package oopGame;

import java.util.Scanner;

import oopGame.menuText;

public class BattleGame
{
  public static void main(String args[])
  {
    menuText.printingText("HomeScreen.txt");
  }

  static void startGame() throws InterruptedException
  {
    Scanner user_input = new Scanner(System.in);
//    for (int iWarriors = 0; iWarriors < 2; iWarriors++)
//    {
//      
//    }
    System.out.print("Name the first warrior:");
    Warrior warrior1 = new Warrior(user_input.next(), 100, 100, 100, 10, "");
    Warrior.classChanger(warrior1, chosingClass(user_input));

    System.out.print("Name the second warrior:");
    Warrior warrior2 = new Warrior(user_input.next(), 100, 100, 100, 10, "");
    Warrior.classChanger(warrior2, chosingClass(user_input));

    checkWarriorName(warrior1, warrior2);
    startFight(warrior1, warrior2);
  }

  private static void checkWarriorName(Warrior warrior1, Warrior warrior2) throws InterruptedException
  {
    if (warrior1.name.equals(warrior2.name))
    {
      warrior1.name += "1";
      warrior2.name += "2";
      System.out.println("Unfortunately warriors names are the same so we changed it to " + warrior1.name
              + " and " + warrior2.name);
      Thread.sleep(1000);
    }
  }

  private static int chosingClass(Scanner user_input)
  {
    menuText.printingText("ClassChooser.txt");
    while (!user_input.hasNextInt())
    {
      System.out.println("Input is not a number!");
      user_input.nextLine();
    }
    return user_input.nextInt();
  }

  private static void startFight(Warrior warriorA, Warrior warriorB)
  {
    Scanner actionChoser = new Scanner(System.in);
    do
    {
      actionMenu(warriorA, warriorB, actionChoser);
      actionMenu(warriorB, warriorA, actionChoser);
    } while (warriorA.health > 0 && warriorB.health > 0);
    checkWhoWin(warriorA, warriorB);
  }

  private static void actionMenu(Warrior warriorA, Warrior warriorB, Scanner actionChoser)
  {
    try {
    String menu = menuText.filePrinter("BattleActionMenu.txt");
    System.out.println(menu.replace("warriorName", warriorA.name));
    checkIfCanDoAction(warriorA, actionChoser);
    int action1 = actionChoser.nextInt();
    actionGoing(warriorA, warriorB, action1);
    Thread.sleep(500);
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  private static void checkIfCanDoAction(Warrior warriorA, Scanner actionChoser)
  {
    while (!actionChoser.hasNextInt())
    {
      System.out.println("Input is not a number!");
      actionChoser.nextLine();
    }
    while (!(warriorA.healthPotions > 0))
    {
      System.out.println("You dont have any Health Potions left.");
      actionChoser.nextInt();
    }
  }

  @SuppressWarnings("resource")
  private static void actionGoing(Warrior warrior1, Warrior warrior2, int action)
  {
    if (action == 1)
    {
      getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, action));
      checkWhoWin(warrior1, warrior2);
      getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, 0));
    }
    else if (action == 2)
    {
      getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, 0));
      checkWhoWin(warrior1, warrior2);
      getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, action));
    }
    else if (action == 3)
    {
      int heal = Warrior.HealValue(warrior1);
      warrior1.health += heal;
      System.out.println("Warrior " + warrior1.name + " healed for " + heal + ". Current Health is "
              + warrior1.health + "\nYou have " + warrior1.healthPotions + " Health Potions left");
    }
    else if (action == 4)
    {
      try
      {
        System.out.println(menuText.filePrinter("skills/" + warrior1.className + "Skills.txt")
                .replace("warriorName", warrior1.name));
      }
      catch (Exception ex)
      {
        System.out.println(ex);
      }
      int skill = new Scanner(System.in).nextInt();
      if (skill == 1)
      {
        getAttackResult(warrior1, warrior2, Warrior.proffesionFinder(warrior1, skill));
        System.out.println("\nYou have " + warrior1.mana + " mana left");
        checkWhoWin(warrior1, warrior2);
        getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, 0));
      }
    }

  }

  private static void getAttackResult(Warrior warriorA, Warrior warriorB, int damage)
  {
    try
    {
      if (damage <= 0)
      {
        System.out.println("\nWarrior " + warriorB.name + " blocked the attack!");
        Thread.sleep(1000);
      }
      else
      {
        System.out.println("\nWarrior " + warriorA.name + " did " + damage + " to " + warriorB.name);
        warriorB.health -= damage;
        Thread.sleep(500);
        System.out.println("Warrior " + warriorB.name + " has " + warriorB.health + " Health");
        Thread.sleep(1000);
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex);
    }
  }

  private static int damageRandomizer(Warrior warrior1, Warrior warrior2, int buff)
  {
    int war1AtkAmt = Warrior.Attack(warrior1);
    int war2BlkAmt = Warrior.Block(warrior2);
    if (buff == 1)
    {
      war1AtkAmt += 10;
    }
    else if (buff == 2)
    {
      war2BlkAmt += 10;
    }
    int damage = war1AtkAmt - war2BlkAmt;
    return damage;
  }

  private static void checkWhoWin(Warrior warrior1, Warrior warrior2)
  {
    if (warrior1.health <= 0)
    {
      System.out.println("\nWarrior " + warrior1.name + " has died and " + warrior2.name + " is Victorious!");
      return;
    }
    else if (warrior2.health <= 0)
    {
      System.out.println("\nWarrior " + warrior2.name + " has died and " + warrior1.name + " is Victorious!");
      return;
    }
    else
    {
      return;
    }
  }
}