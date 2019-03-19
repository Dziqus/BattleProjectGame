package oopGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class menuText
{
  public static String filePrinter(String fileName) throws FileNotFoundException, IOException
  {
    Path path = Paths.get("TextMenus/" + fileName);
    return new String(Files.readAllBytes(path));
  }

  private static void spacing()
  {
    for (int i = 0; i < 20; i++)
    {
      System.out.println("");
    }
  }

  @SuppressWarnings("resource")
  private static void printSubMenu() throws InterruptedException, FileNotFoundException, IOException
  {
    System.out.println(filePrinter("MainMenu.txt"));
    Scanner input = new Scanner(System.in);
    int scan = input.nextInt();
    spacing();
    subMenuChose(scan);
  }

  private static void subMenuChose(int scan) throws InterruptedException, FileNotFoundException, IOException
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
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  private static String[] blacklistedMenus = {"BattleActionMenu.txt", "ClassChooser.txt", "skills"};

  private static boolean checkIfStringContainsList(String input)
  {
    return Arrays.stream(blacklistedMenus).parallel().anyMatch(input::contains);
  }
}
