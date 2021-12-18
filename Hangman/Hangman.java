package Hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {
    FileReader fr;
    BufferedReader br;

    public void runHangman() {
        try {
            fr = new FileReader("Hangman\\Words.txt");
            br = new BufferedReader(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String temp;
        try {
            while ((temp = br.readLine()) != null) {
                words.add(temp);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] line = getRandom(words);
        String quest = line[0];
        String hint = line[1];
        List<Character> guess = new ArrayList<>();
        System.out.println(hint);
        int attempts = 5;
        while (attempts > 0) {
            System.out.println("..................................... ");
            System.out.println(attempts + " Attempts Left");
            status(quest, guess);
            if (!getInput(sc, quest, guess)) {
                attempts--;
            }
            if (status(quest, guess)) {
                System.out.println("You have guessed the word, GG");
                break;
            }
            System.out.print("Guess the entire word: ");
            if (sc.nextLine().toLowerCase().equals(quest)) {
                System.out.println("You have guessed the word, GG");
                break;
            } else {
                System.out.println("Try again");
            }
        }
    }

    public static void vowel(String quest) {
        String vow = "aeiou";
        for (int i = 0; i < quest.length(); i++) {
            if ((vow.indexOf(quest.charAt(i)) != -1)) {
                System.out.print("*\t");
            } else
                System.out.print(" \t");
        }
        System.out.println();
    }

    public static boolean getInput(Scanner sc, String quest, List<Character> guess) {
        System.out.print("Your letter guess: ");
        String input = sc.nextLine();
        guess.add(input.toLowerCase().charAt(0));
        return quest.contains(input.toLowerCase());
    }

    public static String[] getRandom(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size())).split(", ");
    }

    public static boolean status(String quest, List<Character> guess) {
        int count = 0;
        for (int i = 0; i < quest.length(); i++) {
            if (guess.contains(quest.charAt(i))) {
                System.out.print(quest.charAt(i) + "\t");
                count++;
            } else
                System.out.print("_\t");
        }
        System.out.println();
        vowel(quest);
        return quest.length() == count;
    }
}
