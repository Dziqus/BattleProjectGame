package OOPGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class menuText
{
  public static void filePrinter(String fileName)
  {
    try (BufferedReader br = new BufferedReader(new FileReader("TextMenus/"+fileName)))
    {
      String line = null;
      while ((line = br.readLine()) != null)
      {
        System.out.println(line);
      }
      return;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("resource")
  public static void homeScreen() throws InterruptedException, IOException
  {
    filePrinter("HomeScreen.txt");
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
    filePrinter("MainMenu.txt");
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
    else if (scan == 2)
    {
      showInstruction();
    }
    else if (scan == 3)
    {
      showCredits();
    }
    else if (scan == 4)
    {
      showStatistics();
    }
  }

  @SuppressWarnings("resource")
  private static void showInstruction() throws InterruptedException
  {
    filePrinter("Instructions.txt");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }

  @SuppressWarnings("resource")
  private static void showCredits() throws InterruptedException
  {
    filePrinter("Credits.txt");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }

  @SuppressWarnings("resource")
  private static void showStatistics() throws InterruptedException
  {
    filePrinter("ClassStats.txt");
    new Scanner(System.in).nextLine();
    spacing();
    printSubMenu();
  }
}
