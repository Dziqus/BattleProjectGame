package oopGame;

import java.util.Scanner;

public class BattleGame
{
  public static void main(String[] args)
  {
    MenuText.printingText("HomeScreen.txt");
  }

  private static void wait(int time)
  {
    long startTime = System.currentTimeMillis();
    while (true)
    {
      long now = System.currentTimeMillis();
      if (now - startTime >= time)
      {
        break;
      }
    }
  }

  public static void startGame()
  {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Name the first warrior:");
    Warrior warrior1 = new Warrior(userInput.next(), 100, 100, 100, 10, "");
    Warrior.classChanger(warrior1, chosingClass(userInput));

    System.out.print("Name the second warrior:");
    Warrior warrior2 = new Warrior(userInput.next(), 100, 100, 100, 10, "");
    Warrior.classChanger(warrior2, chosingClass(userInput));

    checkWarriorName(warrior1, warrior2);
    startFight(warrior1, warrior2);
  }

  private static void checkWarriorName(Warrior warrior1, Warrior warrior2)
  {
    if (warrior1.name.equals(warrior2.name))
    {
      warrior1.name += "1";
      warrior2.name += "2";
      System.out.println("Unfortunately warriors names are the same so we changed it to " + warrior1.name
              + " and " + warrior2.name);
      wait(1000);
    }
  }

  private static int chosingClass(Scanner userInput)
  {
    MenuText.printingText("ClassChooser.txt");
    while (!userInput.hasNextInt())
    {
      System.out.println("Input is not a number!");
      userInput.nextLine();
    }
    return userInput.nextInt();
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
    try
    {
      System.out.println(MenuText.filePrinter("BattleActionMenu.txt".replace("warriorName", warriorA.name)));
      checkIfCanDoAction(warriorA, actionChoser);
      int action1 = actionChoser.nextInt();
      actionGoing(warriorA, warriorB, action1);
      wait(500);
    }
    catch (Exception ex)
    {
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
    while (warriorA.healthPotions != 0)
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
      int heal = Warrior.healValue(warrior1);
      warrior1.health += heal;
      System.out.println("Warrior " + warrior1.name + " healed for " + heal + ". Current Health is "
              + warrior1.health + "\nYou have " + warrior1.healthPotions + " Health Potions left");
    }
    else if (action == 4)
    {
      try
      {
        System.out.println(MenuText.filePrinter("skills/" + warrior1.className + "Skills.txt")
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
        wait(1000);
      }
      else
      {
        System.out.println("\nWarrior " + warriorA.name + " did " + damage + " to " + warriorB.name);
        warriorB.health -= damage;
        wait(500);
        System.out.println("Warrior " + warriorB.name + " has " + warriorB.health + " Health");
        wait(1000);
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex);
    }
  }

  private static int damageRandomizer(Warrior warrior1, Warrior warrior2, int buff)
  {
    int war1AtkAmt = Warrior.attack(warrior1);
    int war2BlkAmt = Warrior.block(warrior2);
    if (buff == 1)
    {
      war1AtkAmt += 10;
    }
    else if (buff == 2)
    {
      war2BlkAmt += 10;
    }
    return war1AtkAmt - war2BlkAmt;
  }

  private static void checkWhoWin(Warrior warrior1, Warrior warrior2)
  {
    if (warrior1.health <= 0)
    {
      System.out.println("\nWarrior " + warrior1.name + " has died and " + warrior2.name + " is Victorious!");
    }
    else if (warrior2.health <= 0)
    {
      System.out.println("\nWarrior " + warrior2.name + " has died and " + warrior1.name + " is Victorious!");
    }
  }
}