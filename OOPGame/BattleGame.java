package OOPGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import OOPGame.menuText;

public class BattleGame {
	public static void main(String args[]) throws InterruptedException, IOException {
		menuText.printingText("HomeScreen.txt");
	}

	static void startGame() throws InterruptedException, FileNotFoundException, IOException {
		Scanner user_input = new Scanner(System.in);

		System.out.print("Name the first warrior:");
		String input1 = user_input.next();
		Warrior warrior1 = new Warrior(input1, 100, 100, 100);
		Warrior.classChanger(warrior1, chosingClass(user_input));

		System.out.print("Name the second warrior:");
		String input2 = user_input.next();
		Warrior warrior2 = new Warrior(input2, 100, 100, 100);
		Warrior.classChanger(warrior2, chosingClass(user_input));

		checkWarriorName(warrior1, warrior2);
		startFight(warrior1, warrior2);
	}

	private static void checkWarriorName(Warrior warrior1, Warrior warrior2) throws InterruptedException {
		if (warrior1.name.equals(warrior2.name)) {
			warrior1.name += "1";
			warrior2.name += "2";
			System.out.println("Unfortunately warriors names are the same so we changed it to " + warrior1.name
					+ " and " + warrior2.name);
			Thread.sleep(1000);
		}
	}

	private static int chosingClass(Scanner user_input) {
		menuText.printingText("ClassChooser.txt");
		while (!user_input.hasNextInt()) {
			System.out.println("Input is not a number!");
			user_input.nextLine();
		}
		return user_input.nextInt();
	}

	public static void startFight(Warrior warriorA, Warrior warriorB)
			throws InterruptedException, FileNotFoundException, IOException {
		Scanner actionChoser = new Scanner(System.in);
		do {
			actionMenu(warriorA, warriorB, actionChoser);
			actionMenu(warriorB, warriorA, actionChoser);
		} while (warriorA.health > 0 && warriorB.health > 0);
		checkWhoWin(warriorA, warriorB);
	}

	private static void actionMenu(Warrior warriorA, Warrior warriorB, Scanner actionChoser)
			throws InterruptedException, FileNotFoundException, IOException {
		String menu = menuText.filePrinter("BattleActionMenu.txt");
		System.out.println(menu.replace("warriorName", warriorA.name));

		checkIfCanDoAction(warriorA, actionChoser);
		int action1 = actionChoser.nextInt();
		actionGoing(warriorA, warriorB, action1);
		Thread.sleep(500);
	}

	private static void checkIfCanDoAction(Warrior warriorA, Scanner actionChoser) {
		while (!actionChoser.hasNextInt()) {
			System.out.println("Input is not a number!");
			actionChoser.nextLine();
		}
		while (!(warriorA.healthPotions > 0)) {
			System.out.println("You dont have any Health Potions left.");
			actionChoser.nextInt();
		}
	}

	private static void actionGoing(Warrior warrior1, Warrior warrior2, int action) throws InterruptedException {
		if (action == 1) {
			getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, action));
			checkWhoWin(warrior1, warrior2);
			getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, 0));
		} else if (action == 2) {
			getAttackResult(warrior1, warrior2, damageRandomizer(warrior1, warrior2, 0));
			checkWhoWin(warrior1, warrior2);
			getAttackResult(warrior2, warrior1, damageRandomizer(warrior2, warrior1, action));
		} else if (action == 3) {
			int heal = Warrior.HealValue(warrior1);
			warrior1.health += heal;
			System.out.println("Warrior " + warrior1.name + " healed for " + heal + ". Current Health is "
					+ warrior1.health + "\nYou have " + warrior1.healthPotions + " Health Potions left");
		}
	}

	private static void getAttackResult(Warrior warriorA, Warrior warriorB, int damage) throws InterruptedException {
		if (damage <= 0) {
			System.out.println("\nWarrior " + warriorB.name + " blocked the attack!");
			Thread.sleep(1000);
		} else {
			System.out.println("\nWarrior " + warriorA.name + " did " + damage + " to " + warriorB.name);
			warriorB.health -= damage;
			Thread.sleep(500);
			System.out.println("Warrior " + warriorB.name + " has " + warriorB.health + " Health.");
			Thread.sleep(1000);
		}
	}

	public static int damageRandomizer(Warrior warrior1, Warrior warrior2, int buff) {
		int war1AtkAmt = Warrior.Attack(warrior1);
		int war2BlkAmt = Warrior.Block(warrior2);
		if (buff == 1) {
			war1AtkAmt += 30;
		} else if (buff == 2) {
			war2BlkAmt += 30;
		}
		int damage = war1AtkAmt - war2BlkAmt;
		return damage;
	}

	private static void checkWhoWin(Warrior warrior1, Warrior warrior2) {
		if (warrior1.health <= 0) {
			System.out.println("\nWarrior " + warrior1.name + " has died and " + warrior2.name + " is Victorious!");
			return;
		} else if (warrior2.health <= 0) {
			System.out.println("\nWarrior " + warrior2.name + " has died and " + warrior1.name + " is Victorious!");
			return;
		} else {
			return;
		}
	}
}