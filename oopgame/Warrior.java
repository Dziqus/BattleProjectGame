package oopGame;

import java.util.Random;

public class Warrior
{

  public String name;
  public int health;
  public int attkMax;
  public int blckMax;
  public int mana;
  public int healthPotions = 3;
  public String className;

  public Warrior(String Name, int Health, int AttkMax, int BlckMax, int Mana, String ClassName)
  {
    name = Name;
    health = Health;
    attkMax = AttkMax;
    blckMax = BlckMax;
    mana = Mana;
    className = ClassName;
  }

  public static void classChanger(Warrior warrior, int chosed)
  {
    if (chosed == 1)
    {
      warrior.health = 1000;
      warrior.attkMax = 140;
      warrior.blckMax = 30;
      warrior.mana = 30;
      warrior.className = "berserker";
    }
    else if (chosed == 2)
    {
      warrior.health = 1200;
      warrior.attkMax = 100;
      warrior.blckMax = 60;
      warrior.mana = 20;
      warrior.className = "tank";
    }
    else if (chosed == 3)
    {
      warrior.health = 700;
      warrior.attkMax = 200;
      warrior.blckMax = 20;
      warrior.mana = 50;
      warrior.className = "wizzard";
    }
    else
    {
      System.out.println("Wrong class!");
    }
  }

  public static int attack(Warrior warrior)
  {
    return new Random().nextInt(warrior.attkMax + 1 - 0) + 0;
  }

  public static int block(Warrior warrior)
  {
    return new Random().nextInt(warrior.blckMax + 1 - 0) + 0;
  }

  public static int healValue(Warrior warrior)
  {
    warrior.healthPotions -= 1;
    return new Random().nextInt(100 + 1 - 20) + 20;
  }

  public static int proffesionFinder(Warrior warrior, int skill)
  {

    switch (warrior.className)
    {
      case "wizzard":
        if (skill == 1)
        {
          skill = wizzardFireball(warrior);
        }
        break;

      case "berserker":

        break;

      case "tank":

        break;
        
      default:
    	  
    	  break;
    }
    return skill;
  }

  private static int wizzardFireball(Warrior warrior)
  {
    warrior.mana -= 15;
    return 200;
  }
}
