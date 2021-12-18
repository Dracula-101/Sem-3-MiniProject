package Roulette;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Players extends Roulette {
	static String player1;
	static String player2;
	int pos1, pos2;
	static int number1, number2;
	static int gamePointNum;
	static int gamePointPlayer;
	static Scanner input = new Scanner(System.in);

	public Players() {
		System.out.print("\nEnter player 1 name: ");
		player1 = input.next().toUpperCase();
		System.out.print("Enter player 2 name: ");
		player2 = input.next().toUpperCase();
	}

	public static void Winner(int winnerNo) {
		try {
			System.out.println("\nGAME FINISHED!!Announcing Results!!");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (winnerNo == 1)
			succesiveText("\n" + player1 + " has won the GAME!!!");
		else if (winnerNo == 2)
			succesiveText("\n" + player2 + " has won the GAME!!!");
		succesiveText("\nReturning to main menu\n");
		gameflag = true;
		// mainInterface.endRoulette();
	}

	public void getGameInput() {
		if (gameflag)
			return;
		while (true) {
			System.out.print("\nEnter the number to wager on by " + player1 + " :");
			number1 = input.nextInt();
			if (posFinder(number1) != -1) {
				this.pos1 = posFinder(number1);
				System.out.println("Your number is " + number1 + " and its at position " + (pos1 + 1));
				break;
			} else
				System.out.println("\nPick a number that exist in the wheel!!");
		}
		while (true) {
			System.out.print("\nEnter the number to wager on by " + player2 + " :");
			number2 = input.nextInt();
			if (posFinder(number2) == pos1)
				System.out.println("\nYou cant put the same number!!");
			else if (posFinder(number2) != -1) {
				this.pos2 = posFinder(number2);
				System.out.println("Your number is " + number2 + " and its at position " + (pos2 + 1));
				break;
			} else
				System.out.println("\nPick a number that exist in the wheel!!!");
		}
	}

	public int gameInterrupt(int pos) {
		if (pos1 == pos) {
			display();
			gamePoint(player1, player2);
			gamePointPlayer = 2;
			return 1;

		} else if (pos2 == pos) {
			display();
			gamePoint(player2, player1);
			gamePointPlayer = 1;
			return 1;
		}
		return 0;
	}

	public static void displayGameRules() {
		System.out.println("WELCOME TO THE ROULETTE GAME!!!");
		System.out.print("\n-------------------------------------------------\nRules for the Game(y/n):-");
		if (input.next().toUpperCase().charAt(0) == 'Y') {
			String rules = "\n1.There are two player which bet a number on the wheel\n2.If the eliminated number is the players choice then other player choose number\n3.(This is the Game Point)If the  number chosen is eliminated the player who has choosen Wins!!\n4.Otherwise the game continues\n";
			succesiveText(rules);
		}
	}
}

class Wheel extends Roulette {
	Players player = new Players();
	static String spaces[] = new String[6];
	static Random rand = new Random();
	ArrayList<Integer> numForWheel = new ArrayList<Integer>();
	static ArrayList<Integer> randomTime = new ArrayList<Integer>();
	static int decidingFactor;
	static int finalNumber;

	public void intializeGame() {
		for (int i = 1; i < 9; i++) {
			numForWheel.add(i);
		}
		Collections.shuffle(numForWheel);
		for (int i = 0; i < 6; i++) {
			list.insert(numForWheel.get(i));
		}
		for (int i = 0; i < 6; i++) {
			copylist[i] = list.getData(i);
		}
		for (int i = 15; i < 20; i++) {
			randomTime.add(i);
		}

		spaces[0] = "  ";
		spaces[1] = "      ";
		spaces[2] = "          ";
		spaces[3] = "              ";
		spaces[4] = "                  ";
		spaces[5] = "                      ";
		System.out.println("\nPlace your bets on the wheel!!!");
		display();

	}

	public static int choosenNumber() {
		int preciousNum = 0;
		display();
		Collections.shuffle(randomTime);
		int i;
		int time = 18 + getIndex();
		for (i = 0; i <= time; i++) {

			if (list.getData(i % 6) == 0) {
				continue;
			} else {
				try {
					System.out.print("\r" + spaces[i % 6]);
					Thread.sleep((int) (100 + 50 * i));
				} catch (Exception e) {
					System.out.println("Error Occured!!");
				}
			}
		}
		i = i - 1;
		System.out.print("^");
		preciousNum = list.getData(i % 6);
		displayMessage(i % 6);
		return preciousNum;
	}

	public static int getIndex() {
		ArrayList<Integer> leftNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			if (list.getData(i) == 0)
				continue;
			leftNumbers.add(i);
		}
		Collections.shuffle(leftNumbers);
		return leftNumbers.get(rand.nextInt(leftNumbers.size()));
	}

	public void startGame() {
		if (gameflag)
			return;
		int number = 0;
		if (decidingFactor == 1) {
			number = choosenNumber();
			gameEnding(number);
		} else {
			player.getGameInput();
			number = choosenNumber();
			if (player.gameInterrupt(posFinder(number)) == 1) {
				decidingFactor = 1;
			} else if (player.gameInterrupt(posFinder(number)) == 0) {
				System.out.println("The Game Continues as no one is Eliminated!!\n----------------------------------");
				display();
				decidingFactor = 0;
			}
		}
	}

}

class RunGame extends Wheel {

	RunGame() {
		intializeGame();
	}

	public void runGame() {

		while (listChecker() < 5 && !gameflag) {
			startGame();
		}
		if (gameflag)
			return;
		System.out.println("\nOnly last two numbers are left to bet!!Pick Carefully");
		player.getGameInput();
		finalNumber = choosenNumber();
		if (finalNumber == Players.number1)
			checkWinner(2);
		else if (finalNumber == Players.number2)
			checkWinner(1);
	}
}

public class Roulette {
	static LinkedList list = new LinkedList();
	static int copylist[] = new int[6];
	static boolean gameflag = false;

	public void runGAME() {
		Players.displayGameRules();
		RunGame newGame = new RunGame();
		newGame.runGame();
		if (gameflag)
			return;
	}

	Scanner input = new Scanner(System.in);

	public static void succesiveText(String text) {
		for (int i = 0; i < text.length(); i++) {
			try {

				System.out.print(text.charAt(i));
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("Error occurred!!!");
			}
		}
	}

	public static void patternGenerator() {
		System.out.print("\n");
		for (int i = 0; i <= 5; i++)
			if (list.getData(i) > 9)
				System.out.print("+----");
			else
				System.out.print("+---");
		System.out.println("+");
	}

	public static void display() {
		char charlist[] = new char[6];
		for (int i = 0; i < 6; i++) {
			if (list.getData(i) == 0)
				charlist[i] = 'X';
			else
				charlist[i] = (char) (list.getData(i) + '0');
		}
		System.out.println("\nThe Wheel is :");
		patternGenerator();
		System.out.print("| ");
		for (int i = 0; i <= 5; i++) {
			System.out.print(charlist[i] + " | ");
		}
		patternGenerator();
	}

	public static void displayMessage(int number) {

		System.out.println("\nThe number eliminated is :" + list.getData(number));
		list.makeZero(number);
	}

	public void gamePoint(String player1, String player2) {
		if (gameflag)
			return;
		System.out.println("This is the Game Point!!!");
		while (true) {
			System.out
					.print("\nOops! " + player1 + " ,you have lost the bet.Now " + player2 + " will choose a number: ");
			Players.gamePointNum = input.nextInt();
			if (posFinder(Players.gamePointNum) != -1) {
				System.out.print("Your number is " + Players.gamePointNum + " and its at position "
						+ posFinder(Players.gamePointNum));
				break;
			} else
				System.out.println("Enter a correct number!!");
		}
		if (listChecker() - 1 == 4) {
			int finalNumber = Wheel.choosenNumber();
			if (finalNumber == Players.gamePointNum && player1 == Players.player2) {
				checkWinner(1);
			} else if (finalNumber == Players.gamePointNum && player1 == Players.player1)
				checkWinner(2);

		}
	}

	public void gameEnding(int number) {
		if (number == Players.gamePointNum) {
			checkWinner(Players.gamePointPlayer);
		} else {
			System.out.println("The number eliminated is not the choosen one.Game start Again!!");
			Wheel.decidingFactor = 0;
			display();
		}
	}

	public void checkWinner(int value) {
		Players.Winner(value);
	}

	public int listChecker() {
		int count = 1;
		for (int i = 0; i < 6; i++)
			if (list.getData(i) == 0)
				count++;
		return count;
	}

	public int posFinder(int number) {
		for (int i = 0; i < 6; i++) {
			if (copylist[i] == number)
				return i;
		}
		return -1;
	}

	public static void gameEndingBit() {
		for (int i = 3; i > 0; i--) {
			System.out.print(i);
			try {
				Thread.sleep(400);
				System.out.print(".");
				Thread.sleep(400);
				System.out.print(".");
				Thread.sleep(400);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			URI oURL = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
			desktop.browse(oURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
