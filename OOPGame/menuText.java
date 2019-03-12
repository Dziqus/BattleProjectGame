package OOPGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import sun.net.NetworkServer;

public class menuText
{
  public static String filePrinter(String fileName) throws FileNotFoundException, IOException
  {
    Path path = Paths.get("TextMenus/"+fileName);
    return new String (Files.readAllBytes(path));
    
    /*
    try (BufferedReader br = new BufferedReader(new FileReader("TextMenus/"+fileName)))
    {
      String line = null;
      while ((line = br.readLine()) != null)
      {
        System.out.println(line);
      }
      return;
    }*/
  }

  private static void spacing()
  {
    for (int i = 0; i < 20; i++)
    {
      System.out.println("");
    }
  }

  @SuppressWarnings("resource")
  public static void actionMenu() throws FileNotFoundException, IOException
  {
    System.out.println(filePrinter("BattleActionMenu.txt"));
    new Scanner(System.in).nextLine();
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

  private static void subMenuChose(int scan) throws InterruptedException
  {
    if (scan == 1)
    {
      BattleGame.startGame();
    }
    else if (scan == 2)
    {
      testPrinting("Instructions.txt");
    }
    else if (scan == 3)
    {
      testPrinting("Credits.txt");
    }
    else if (scan == 4)
    {
      testPrinting("ClassStats.txt");
    }
  }
  
  @SuppressWarnings("resource")
  public static void testPrinting(String filename)
  {
    try
    {
      System.out.println(filePrinter(filename));
      new Scanner(System.in).nextLine();
      spacing();
      printSubMenu();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
