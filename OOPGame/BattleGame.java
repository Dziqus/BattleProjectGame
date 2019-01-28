package OOPGame;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BattleGame
{
  public static void main(String args[]) throws InterruptedException, IOException
  {
    mainMenu();
  }

  private static void mainMenu() throws InterruptedException, IOException
  {
    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄ \n" + 
            "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" + 
            "\n" + 
            "　 　 　 　 　 ▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 \n" + 
            "　 　 　 　 　 ▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░▒█░░ █░░█ 　 \n" + 
            "　 　 　 　 　 ▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀▀▀▀ 　 \n" + 
            "\n" + 
            "▒█░░▒█ █▀▀█ █▀▀█ █▀▀█ ░▀░ █▀▀█ █▀▀█ 　 ▒█▀▀█ █▀▀█ ▀▀█▀▀ ▀▀█▀▀ █░░ █▀▀ █▀▀ \n" + 
            "▒█▒█▒█ █▄▄█ █▄▄▀ █▄▄▀ ▀█▀ █░░█ █▄▄▀ 　 ▒█▀▀▄ █▄▄█ ░░█░░ ░░█░░ █░░ █▀▀ ▀▀█ \n" + 
            "▒█▄▀▄█ ▀░░▀ ▀░▀▀ ▀░▀▀ ▀▀▀ ▀▀▀▀ ▀░▀▀ 　 ▒█▄▄█ ▀░░▀ ░░▀░░ ░░▀░░ ▀▀▀ ▀▀▀ ▀▀▀ \n" + 
            "\n" + 
            "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄ \n" + 
            "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" + 
            "                      Press any key to continue...");
    @SuppressWarnings("resource")
    String scan = new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }

  private static void spacing()
  {
    for (int i = 0; i < 20; i++)
    {
      System.out.println("");
    }    
  }

  @SuppressWarnings("resource")
  private static void printSubMenu() throws InterruptedException
  {
    System.out.println("\n================================\n"
            + "Where do you want to go:\n"
            + "\nStart Game............[1]"
            + "\nInstructions..........[2]"
            + "\nCredits...............[3]"
            + "\nClass statistics......[4]"
            + "\n================================");
    Scanner input = new Scanner(System.in);
    int scan = input.nextInt();
    subMenuChose(scan);
  }

  private static void subMenuChose(int scan) throws InterruptedException
  {
    if (scan == 1)
    {
      startGame();
    }
    else if (scan == 2) {
      showInstruction();
    }
    else if (scan == 3) {
      showCredits();
    }
    else if (scan == 4) {
      showStatistics();
    } 
  }

  private static void showInstruction()
  {
    System.out.println("\n================================\n"
            + "This is a tour based gameplay."
            + "The goal is to kill the other players warrior."
            + "At the beggining you choose "
            + "\n================================");
  }

  private static void showCredits()
  {
    System.out.println("\n================================\n"
            + "Actually I (Jacek Lajdecki) am the only one credit LOL"
            + "\n================================");
  }

  private static void showStatistics()
  {
    System.out.println("\n================================\n"
            + "Statistics: Berserker  Tank  Wizzard"
            + "\nHealth:       1000     1200    800  "
            + "\nMax Attack:   140      100     200  "
            + "\nMax Defense:  30       60      20  "
            + "\n================================");
  }

  private static void startGame() throws InterruptedException
  {
    Scanner user_input = new Scanner(System.in);

    System.out.print("Name the first warrior:");
    String input1 = user_input.next();
    chosingClass(user_input);
    int class1 = user_input.nextInt();
    Warrior warrior1 = new Warrior(input1, 100, 100, 100);
    Warrior.classChanger(warrior1, class1);

    
    System.out.print("Name the second warrior:");
    String input2 = user_input.next();
    chosingClass(user_input);
    int class2 = user_input.nextInt();
    Warrior warrior2 = new Warrior(input2, 100, 100, 100);
    Warrior.classChanger(warrior2, class2);

    Battle.startFight(warrior1, warrior2);
  }

  private static void chosingClass(Scanner user_input)
  {
    System.out.println("Chose your warrior class:"
            + "\n[1] Berserker"
            + "\n[2] Tank"
            + "\n[3] Wizzard");
    while (!user_input.hasNextInt())
    {
      System.out.println("Input is not a number!");
      user_input.nextLine();
    }
  }
}

class Warrior
{

  public String name;
  public int health;
  public int attkMax;
  public int blckMax;
  public int healthPotions = 3;

  public Warrior(String Name, int Health, int AttkMax, int BlckMax)
  {
    name = Name;
    health = Health;
    attkMax = AttkMax;
    blckMax = BlckMax;
  }

  public static void classChanger(Warrior warrior, int chosed)
  {
    if (chosed == 1)
    {
      warrior.health = 1000;
      warrior.attkMax = 140;
      warrior.blckMax = 30;
    }
    else if (chosed == 2)
    {
      warrior.health = 1200;
      warrior.attkMax = 100;
      warrior.blckMax = 60;
    }
    else if (chosed == 3)
    {
      warrior.health = 700;
      warrior.attkMax = 200;
      warrior.blckMax = 20;
    }
  }

  public static int Attack(Warrior warrior)
  {

    return new Random().nextInt(warrior.attkMax + 1 - 0) + 0;
  }

  public static int Block(Warrior warrior)
  {
    return new Random().nextInt(warrior.blckMax + 1 - 0) + 0;
  }

  public static int HealValue(Warrior warrior)
  {
    warrior.healthPotions -= 1;
    return new Random().nextInt(100 + 1 - 20) + 20;
  }
}

class Battle
{
  public static void startFight(Warrior warriorA, Warrior warriorB) throws InterruptedException
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
          throws InterruptedException
  {
    System.out.println("\n================================\n"
            + warriorA.name + " chose what you want to do:"
            + "\n[1] Attack\n[2] Block\n[3] Heal Potion"
            + "\n================================");
    checkIfCanDoAction(warriorA, actionChoser);
    int action1 = actionChoser.nextInt();
    actionGoing(warriorA, warriorB, action1);
    Thread.sleep(1500);
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

  private static void actionGoing(Warrior warrior1, Warrior warrior2, int action) throws InterruptedException
  {
    if (action == 1)
    {
      getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, action));
      getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, 0));
    }
    else if (action == 2)
    {
      getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, 0));
      getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, action));
    }
    else if (action == 3)
    {
      int heal = Warrior.HealValue(warrior1);
      warrior1.health += heal;
      System.out.println("Warrior " + warrior1.name + " healed for " + heal + ". Current Health is "
              + warrior1.health + "\nYou have " + warrior1.healthPotions + " Health Potions left");
    }
  }

  private static void getAttackResult(Warrior warriorA, Warrior warriorB, int damage)
          throws InterruptedException
  {
    if (damage <= 0)
    {
      System.out.println("\nWarrior " + warriorB.name + " blocked the attack!");
      Thread.sleep(300);
    }
    else
    {
      System.out.println("\nWarrior " + warriorA.name + " did " + damage + " to " + warriorB.name);
      warriorB.health -= damage;
      System.out.println("Warrior " + warriorB.name + " has " + warriorB.health + " Health.");
      Thread.sleep(300);
    }
  }

  public static int damageRandomizer(Warrior warrior1, Warrior warrior2, int buff)
  {
    int war1AtkAmt = Warrior.Attack(warrior1);
    int war2BlkAmt = Warrior.Block(warrior2);
    if (buff == 1)
    {
      war1AtkAmt += 30;
    }else if (buff == 2)
    {
      war2BlkAmt += 30;
    }
    int damage = war1AtkAmt - war2BlkAmt;
    return damage;
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
    else
    {
      return;
    }
  }
}