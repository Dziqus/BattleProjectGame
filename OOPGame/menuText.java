package OOPGame;

import java.io.IOException;
import java.util.Scanner;

public class menuText
{
  @SuppressWarnings("resource")
  public static void mainMenu() throws InterruptedException, IOException
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
    new Scanner(System.in).nextLine();
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
            + "\n================================\n"
            + "press any key to continue...");
    Scanner input = new Scanner(System.in);
    int scan = input.nextInt();
    spacing();
    subMenuChose(scan);
  }

  private static void subMenuChose(int scan) throws InterruptedException
  {
    if (scan == 1)
    {
      BattleGame.startGame();
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

  @SuppressWarnings("resource")
  private static void showInstruction() throws InterruptedException
  {
    System.out.println("\n         ================================"
                      + "\n         This is a tour based gameplay."
                      + "\n  The goal is to kill the other players warrior."
                      + "\nAt the beggining you choose name of the warrior and class."
                      + "\n Than the game begin and you can chose what to do."
                      + "\nYou have 3 Health potions. You can also atack and block."
                      + "\n    Attack and Block increases its value by 20."
                      + "\n\n                 HAVE FUN!"
                      + "\n        ================================"
                      + "\n          press any key to continue...");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }

  @SuppressWarnings("resource")
  private static void showCredits() throws InterruptedException
  {
    System.out.println("\n================================\n"
            + "Actually I (Jacek Lajdecki) am the only one credit LOL"
            + "\n================================\n"
            + "press any key to continue...");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }

  @SuppressWarnings("resource")
  private static void showStatistics() throws InterruptedException
  {
    System.out.println("\n================================\n"
            + "Statistics: Berserker  Tank  Wizzard"
            + "\nHealth:       1000     1200    800  "
            + "\nMax Attack:   140      100     200  "
            + "\nMax Defense:  30       60      20  "
            + "\n================================\n"
            + "press any key to continue...");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }
}
