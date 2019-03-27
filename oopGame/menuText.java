package OOPGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class menuText
{
  public static String filePrinter(String fileName)
  {
    String str = null;
    try
    {
      str = new String(Files.readAllBytes(Paths.get("TextMenus/" + fileName)));
    }
    catch (IOException ex)
    {
      System.out.println();
      ex.printStackTrace();
    }
    return str;
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
    System.out.println(filePrinter("MainMenu.txt"));
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
      printingText("Instructions.txt");
    }
    else if (scan == 3)
    {
      printingText("Credits.txt");
    }
    else if (scan == 4)
    {
      printingText("ClassStats.txt");
    }
  }

  public static void printingText(String filename)
  {
    try
    {
      System.out.println(filePrinter(filename));
      while (!checkIfStringContainsList(filename))
      {
        new Scanner(System.in).nextLine();
        spacing();
        printSubMenu();
      }
    }
    catch (InterruptedException ex)
    {
      System.out.println("The action was interrupted");
      ex.printStackTrace();
    }
  }
  
  private static List<String> blacklistedMenus = Arrays.asList("BattleActionMenu.txt", "ClassChooser.txt", "skills");

  private static boolean checkIfStringContainsList(String input)
  {
    return blacklistedMenus.contains(input);
  }
}
