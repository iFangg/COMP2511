package splitter;
import java.util.Scanner;

public class Splitter {
    public static void main(String[] args) {
        System.out.println("Enter a sentence specified by spaces only:");
        Scanner str = new Scanner(System.in);
        String input = str.nextLine();
        String[] words = input.split(" ", 0);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        str.close();
    }
}
